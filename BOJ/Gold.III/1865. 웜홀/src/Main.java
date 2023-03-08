import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            doCase();
        }
    }

    private static void doCase()throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[n+1];
        IntStream.range(1, n+1).forEach(i -> nodes[i] = new Node());
        while(m-- > 0){
            int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodes[split[0]].addEdge(split[1], split[2]);
            nodes[split[1]].addEdge(split[0], split[2]);
        }
        while(w-- > 0){
            int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodes[split[0]].addEdge(split[1], -1*split[2]);
        }
        if(bellmanFord(nodes, n)){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

    private static boolean bellmanFord(Node[] nodes, int n){
        int[] distance = new int[n+1];
        distance[1] = 0;
        boolean updated = false;
        for(int i = 1; i < n; i++){
            updated = false;
            for(int j = 1; j <=n; j++){
                for(Edge edge : nodes[j].getEdges()){
                    if(distance[edge.getEnd()] > distance[j] + edge.getDistance()){
                        distance[edge.getEnd()] = distance[j] + edge.getDistance();
                        updated = true;
                    }
                }
            }
            if(!updated) break;
        }
        if(updated){
            for (int i = 1; i <= n; i++) {
                for (Edge road : nodes[i].getEdges()) {
                    if (distance[road.end] > distance[i] + road.getDistance()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Node{
        private final List<Edge> edges = new ArrayList<>();

        public List<Edge> getEdges() {
            return edges;
        }

        public void addEdge(int end, int distance){
            edges.add(new Edge(end, distance));
        }
    }

    static class Edge{
        private int end;
        private int distance;

        public Edge(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }

        public int getEnd() {
            return end;
        }

        public int getDistance() {
            return distance;
        }
    }
}