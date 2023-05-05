import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int end = 0;
    private static int finalDistance = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n+1];
        for(int index = 1; index <=n; index++){
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodes[inputs[0]] = new Node();
            for(int i = 1; i < inputs.length-1; i+=2){
                nodes[inputs[0]].addEdge(inputs[i], inputs[i+1]);
            }
        }
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        dfs(new Edge(1, 0), nodes, visited);
        visited[1] = false;
        visited[end] = true;
        dfs(new Edge(end, 0), nodes, visited);
        System.out.println(finalDistance);
    }

    private static void dfs(Edge currentLine, Node[] nodes, boolean[] visited){
        int current = currentLine.getNext();
        int distance = currentLine.getDistance();
        for(Edge edge : nodes[current].getEdges()){
            if(visited[edge.getNext()]) continue;
            visited[edge.getNext()] = true;
            dfs(new Edge(edge.getNext(), distance + edge.getDistance()), nodes, visited);
            visited[edge.getNext()] = false;
        }
        if(finalDistance < distance){
            finalDistance = distance;
            end = current;
        }
    }

    static class Node{

        private List<Edge> edges = new ArrayList<>();

        public void addEdge(int next, int distance){
            edges.add(new Edge(next, distance));
        }

        public List<Edge> getEdges(){
            return edges;
        }
    }

    static class Edge{

        private final int next;
        private final int distance;

        public Edge(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }

        public int getNext() {
            return next;
        }

        public int getDistance() {
            return distance;
        }
    }
}