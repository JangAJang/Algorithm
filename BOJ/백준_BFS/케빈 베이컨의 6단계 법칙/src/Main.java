import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        Map<Integer, Set<Integer>> map = new HashMap<>();
        IntStream.range(1, node+1).forEach(i -> map.put(i, new HashSet<>()));
        while(edge-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int leastIndex = 0;
        int result = Integer.MAX_VALUE;
        for(int index = 1; index <= node; index++){
            int countOnIndex = countKevinBaconNumber(index, map);
            if(result == countOnIndex) continue;
            if(result > countOnIndex){
                leastIndex = index;
                result = countOnIndex;
            }
        }
        System.out.println(leastIndex);
    }

    private static int countKevinBaconNumber(int start, Map<Integer, Set<Integer>> map){
        int[] nodes = new int[map.keySet().size()+1];
        boolean[] visited = new boolean[map.keySet().size()+1];
        Arrays.fill(nodes, Integer.MAX_VALUE);
        nodes[0] = 0;
        nodes[start] = 0;
        visited[start] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : map.get(current)){
                if(visited[next]) continue;
                visited[next] = true;
                nodes[next] = Math.min(nodes[current]+1, nodes[next]);
                queue.add(next);
            }
        }
        return Arrays.stream(nodes).sum();
    }
}