import java.util.*;

class Solution {

    boolean[] visited;

    public int solution(int n, int[][] edge) {
        HashMap<Integer, List<Integer>> nodes = new HashMap<>();
        visited = new boolean[n+1];
        visited[1] = true;
        for(int index = 1; index <=n; index++){
            nodes.put(index, new ArrayList<>());
        }
        for(int[] edgeEach : edge){
            int a = edgeEach[0];
            int b = edgeEach[1];
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        distance[1] = 0;
        bfs(distance, nodes);
        Arrays.sort(distance);
        int biggest = distance[n];
        int result = 1;
        for(int index = n-1; index >=1; index--){
            if(biggest == distance[index]) result++;
        }
        return result;
    }

    private void bfs(int[] distance, HashMap<Integer, List<Integer>> nodes){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : nodes.get(current)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    distance[next] = Math.min(distance[current]+1, distance[next]);
                }
            }
        }
    }
}