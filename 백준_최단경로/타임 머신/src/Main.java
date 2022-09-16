import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static class Edge{
        int start, end;
        long distance;

        public void setStart(int start) {
            this.start = start;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public void setDistance(long distance) {
            this.distance = distance;
        }
    }

    public static class Graph{
        int V, E;
        Edge[] edge;

        public Graph(int v, int e){
            V = v;
            E = e;
            edge = new Edge[e];
            for(int i=0; i<E; i++){
                edge[i] = new Edge();
            }
        }


    }

    public static void Bellman_Ford(Graph graph, int start){
        int V = graph.V;
        int E = graph.E;
        long[] distance = new long[V+1];
        for(int i=1 ; i<=V; i++){
            distance[i] = Long.MAX_VALUE;
        }
        distance[start] = 0;
        for(int i=2; i<=V; i++){
            for(int j=0; j<E; j++){
                int u = graph.edge[j].start;
                int v = graph.edge[j].end;
                long weight = graph.edge[j].distance;
                if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + weight){
                    distance[v] = Math.min(distance[v], distance[u] + weight);
                }
            }
        }

        for(int i=0; i<E; i++){
            int u = graph.edge[i].start;
            int v = graph.edge[i].end;
            long weight = graph.edge[i].distance;
            if(distance[u] != Long.MAX_VALUE && distance[v] > distance[u] + weight){
                System.out.println("-1");
                return;
            }
        }
        for(int i=2; i<=V; i++){
           if(distance[i] != Long.MAX_VALUE) System.out.println(distance[i]);
           else System.out.println("-1");
        }
    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph graph = new Graph(N, M);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long distance = Long.parseLong(st.nextToken());
            graph.edge[i].setStart(start);
            graph.edge[i].setEnd(end);
            graph.edge[i].setDistance(distance);
        }
        Bellman_Ford(graph, 1);
    }
}
