import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();
        solution.solution();
    }

    static class Solution{
        private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private int[] parent;

        public void solution()throws Exception{
            int n = Integer.parseInt(br.readLine());
            parent = new int[n+1];
            IntStream.range(1, n+1).forEach(i-> parent[i] = i);
            int e = Integer.parseInt(br.readLine());
            List<Edge> edges = new ArrayList<>();
            StringTokenizer st;
            while(e-- > 0){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                edges.add(new Edge(start, end, dist));
            }
            Collections.sort(edges, Comparator.comparingInt(Edge::getDist));
            int result = 0;
            for(Edge edge : edges){
                if(find(edge.getStart()) == find(edge.getEnd())) continue;
                union(edge.getStart(), edge.getEnd());
                result += edge.getDist();
            }
            System.out.println(result);
        }

        private int find(int a){
            if(a == parent[a]) return a;
            return parent[a] = find(parent[a]);
        }

        private void union(int a, int b){
            int parentA = find(a);
            int parentB = find(b);
            if(parentA == parentB) return;
            parent[parentB] = parentA;
        }
    }

    static class Edge{

        private int start;
        private int end;
        private int dist;

        public Edge(int start, int end, int dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        public int getStart(){
            return this.start;
        }

        public int getEnd(){
            return this.end;
        }

        public int getDist(){
            return this.dist;
        }
    }
}