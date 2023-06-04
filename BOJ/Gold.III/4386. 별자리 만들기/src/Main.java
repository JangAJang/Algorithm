import java.io.*;
import java.util.*;
import java.util.stream.*;

// Gold.3 4386 별자리 만들기
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingDouble(i -> i.dist));
    private static int[] parent;
    private static double[][] node;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        node = new double[n+1][2];
        for(int index = 1; index <=n; index++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            node[index][0] = Double.parseDouble(st.nextToken());
            node[index][1] = Double.parseDouble(st.nextToken());
            parent[index] = index;
        }
        for(int x = 1; x <=n; x++){
            for(int y = x+1; y <=n; y++){
                edges.offer(new Edge(x, y));
            }
        }
        System.out.printf( "%.2f\n", countDist());
    }

    private static double countDist(){
        double dist = 0;
        int count = parent.length-2;
        while(!edges.isEmpty() && count > 0) {
            Edge edge = edges.poll();
            if(union(edge.x, edge.y)) {
                dist += edge.dist;
                count--;
            }
        }
        return dist;
    }

    private static int find(int a) {
        if( a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if( parentB == parentA) return false;
        parent[Math.min(parentA, parentB)] = Math.max(parentA, parentB);
        return true;
    }

    static class Edge{
        double dist;
        int x;
        int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
            dist = Math.sqrt(Math.pow(node[x][0] - node[y][0], 2) + Math.pow(node[x][1] - node[y][1], 2));
        }
    }
}