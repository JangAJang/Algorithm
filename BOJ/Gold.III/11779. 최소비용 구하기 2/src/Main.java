import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n+1];
        IntStream.range(1, n+1).forEach(i -> nodes[i] = new Node());
        while(edges-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            nodes[start].addEdge(end, dist);
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] distanceTo = dijkstra(nodes, start);
        System.out.println(distanceTo[end]);
        System.out.println(list.get(end).size());
        StringBuilder sb = new StringBuilder();
        for(int node : list.get(end)){
            sb.append(node).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int[] dijkstra(Node[] nodes, int start){
        boolean[] visited = new boolean[nodes.length];
        for(int index = 0; index < nodes.length; index++){
            list.add(new ArrayList<>());
        }
        int[] dist = new int[nodes.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        list.get(start).add(start);
        visited[start] = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i->dist[i]));
        pq.offer(start);
        while (!pq.isEmpty()) {
            int current = pq.poll();
            if (!visited[current]) {
                visited[current] = true;
            }
            for (int next : nodes[current].getNextNodes()) {
                if (!visited[next] && nodes[current].containsEdgeTo(next)) {
                    if( dist[next] > dist[current] + nodes[current].getDistanceTo(next)){
                        dist[next] = dist[current] + nodes[current].getDistanceTo(next);
                        pq.offer(next);
                        list.get(next).clear();
                        list.get(next).addAll(list.get(current));
                        list.get(next).add(next);
                    }
                }
            }
        }
        return dist;
    }

    static class Node{
        private final HashMap<Integer, Integer> map;

        public Node() {
            map = new HashMap<>();
        }

        public void addEdge(int end, int dist){
            map.put(end, Math.min(map.getOrDefault(end, Integer.MAX_VALUE), dist));
        }

        public int getDistanceTo(int end){
            return map.get(end);
        }

        public boolean containsEdgeTo(int end){
            return map.containsKey(end);
        }

        public Set<Integer> getNextNodes(){
            return map.keySet();
        }
    }
}