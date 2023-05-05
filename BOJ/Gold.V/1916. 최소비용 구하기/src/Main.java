import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n+1];
        IntStream.range(1, n+1).forEach(i -> nodes[i] = new Node());
        int edges = Integer.parseInt(br.readLine());
        while(edges-- > 0){
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodes[info[0]].addEdge(info[1], info[2]);
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] result = getDistanceFrom(nodes, start);
        System.out.println(result[end]);
    }

    private static int[] getDistanceFrom(Node[] nodes, int start) {
        int[] result = new int[nodes.length];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i-> result[i]));
        pq.offer(start);
        boolean[] visited = new boolean[nodes.length];
        while(!pq.isEmpty()) {
            int current = pq.poll();
            if(visited[current]) continue;
            visited[current] = true;
            for(int next : nodes[current].getNext()){
                int distance = result[current] + nodes[current].getDistanceTo(next);
                if(result[next] > distance && !visited[next]){
                    result[next] = distance;
                    pq.offer(next);
                }
            }
        }
        return result;
    }

    static class Node{
        private final HashMap<Integer, Integer> map;

        public Node() {
            map = new HashMap<>();
        }

        public void addEdge(int next, int dist){
            dist = Math.min(dist, map.getOrDefault(next, Integer.MAX_VALUE));
            map.put(next, dist);
        }

        public Set<Integer> getNext(){
            return map.keySet();
        }

        public int getDistanceTo(int next){
            return map.get(next);
        }
    }
}