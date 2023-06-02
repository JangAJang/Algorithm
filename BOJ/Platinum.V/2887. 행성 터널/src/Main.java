import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] parent;
    static List<Edge> edgeList;
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Planet[] planets = new Planet[n];
        IntStream.range(0, n).forEach(i -> planets[i] = createPlanet(i));
        edgeList = new ArrayList<>();
        Arrays.sort(planets, Comparator.comparingInt(i-> i.x));
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(planets[i].x - planets[i + 1].x);
            edgeList.add(new Edge(planets[i].value, planets[i + 1].value, weight));
        }
        Arrays.sort(planets, Comparator.comparingInt(i-> i.y));
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(planets[i].y - planets[i + 1].y);
            edgeList.add(new Edge(planets[i].value, planets[i + 1].value, weight));
        }
        Arrays.sort(planets, Comparator.comparingInt(i-> i.z));
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(planets[i].z - planets[i + 1].z);
            edgeList.add(new Edge(planets[i].value, planets[i + 1].value, weight));
        }
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Collections.sort(edgeList);
        int ans = 0;
        for (Edge edge : edgeList) {
            if (find(edge.start) != find(edge.end)) {
                ans += edge.weight;
                union(edge.start, edge.end);
            }
        }
        System.out.println(ans);
    }

    private static Planet createPlanet(int i){
        try{
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            return new Planet(i, x, y, z);
        } catch (IOException e){
            return null;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    static class Planet{
        int value;
        int x;
        int y;
        int z;

        public Planet(int value, int x, int y, int z) {
            this.value = value;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return weight - edge.weight;
        }
    }
}