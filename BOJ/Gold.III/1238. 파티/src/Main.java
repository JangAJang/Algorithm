import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int result = 0;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine(), " ");
        int villageCount = Integer.parseInt(st.nextToken());
        int roadCount = Integer.parseInt(st.nextToken());
        int partyPlace = Integer.parseInt(st.nextToken());
        Map<Integer, List<Line>> go = new HashMap<>();
        IntStream.range(1, villageCount+1).forEach(i -> go.put(i, new ArrayList<>()));
        Map<Integer, List<Line>> back = new HashMap<>();
        IntStream.range(1, villageCount+1).forEach(i -> back.put(i, new ArrayList<>()));
        while(roadCount-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            go.get(end).add(new Line(start, dist));
            back.get(start).add(new Line(end, dist));
        }
        int[] goTo = dijkstra(villageCount, partyPlace, go);
        int[] backTo = dijkstra(villageCount, partyPlace, back);
        IntStream.range(1, villageCount+1).forEach(i -> result = Math.max(result, goTo[i] + backTo[i]));
        System.out.println(result);
    }

    private static int[] dijkstra(int villageCount, int partyPlace, Map<Integer, List<Line>> road){
        boolean[] visited = new boolean[villageCount+1];
        visited[partyPlace] = true;
        int[] dist = new int[villageCount+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[partyPlace] = 0;
        PriorityQueue<Line> queue = new PriorityQueue<>();
        queue.add(new Line(partyPlace, 0));
        while(!queue.isEmpty()){
            Line currentLine = queue.poll();
            int location = currentLine.getDest();
            if(!visited[location]) visited[location] = true;
            for(Line next : road.get(location)){
                if(!visited[next.getDest()] && dist[next.getDest()] > dist[location] + next.getWeight()){
                    dist[next.getDest()] = dist[location] + next.getWeight();
                    queue.add(new Line(next.getDest(), dist[next.getDest()]));
                }
            }
        }
        return dist;
    }

    static class Line implements Comparable<Line>{

        int dest;
        int weight;

        public Line(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }

        public int getDest() {
            return dest;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Line arg0){
            return weight - arg0.weight;
        }
    }
}