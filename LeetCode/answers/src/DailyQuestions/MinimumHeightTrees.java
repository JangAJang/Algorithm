package DailyQuestions;
import java.util.*;

public class MinimumHeightTrees {

    private Map<Integer, List<Integer>> map;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        map = new HashMap<>();
        for(int index = 0; index < n; index++) {
            map.put(index, new ArrayList<>());
        }
        for(int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int firstLeaf = findDeep(0, new boolean[n]);
        int secondLeaf = findDeep(firstLeaf, new boolean[n]);
        List<Integer> route = findRoute(firstLeaf, secondLeaf, new boolean[n]);
        int mid = route.size()/2;
        if(route.size() % 2 != 0) {
            return List.of(route.get(mid));
        }

        return List.of(route.get(mid-1), route.get(mid));
    }

    private List<Integer> findRoute(int first, int second, boolean[] visited) {
        List<Integer> route = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> parentMap = new HashMap<>();

        // 첫 번째 끝점에서 시작하여 DFS를 수행하면서 부모 노드를 기록합니다.
        dfs(first, visited, parentMap);

        // 두 번째 끝점에서 시작하여 첫 번째 끝점까지의 경로를 추적합니다.
        int current = second;
        while (current != first) {
            route.add(current);
            current = parentMap.get(current);
        }
        // 첫 번째 끝점을 경로에 추가합니다.
        route.add(first);

        // 경로를 역순으로 반환합니다.
        Collections.reverse(route);
        return route;
    }

    private void dfs(int node, boolean[] visited, Map<Integer, Integer> parentMap) {
        visited[node] = true;
        for (int next : map.get(node)) {
            if (!visited[next]) {
                parentMap.put(next, node); // 부모 노드 기록
                dfs(next, visited, parentMap);
            }
        }
    }


    private int findDeep(
            int start,
            boolean[] visited) {
        Deque<int[]> deque = new ArrayDeque<>();
        int leafNode = start;
        int depth = 0;
        deque.offer(new int[]{leafNode, depth});
        while(!deque.isEmpty()) {
            int[] current = deque.pop();
            int currentNode = current[0];
            int currentDepth = current[1];
            if(visited[currentNode]) continue;
            visited[currentNode] = true;
            if(currentDepth > depth) {
                leafNode = currentNode;
                depth = currentDepth;
            }
            for(int next : map.get(currentNode)) {
                deque.offer(new int[]{next, currentDepth+1});
            }
        }
        return leafNode;
    }
}
