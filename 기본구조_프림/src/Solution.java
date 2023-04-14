import java.util.*;

public class Solution {

    public int solution(int v, int[][] edges){
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getDist));
        HashMap<Integer, List<Edge>> map = new HashMap<>();
        boolean[] visited = new boolean[v+1];
        for(int index = 1; index <=v;index++){
            map.put(index, new ArrayList<>());
        }
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int dist = edge[2];
            
            map.get(to).put(from, dist);
        }
        queue.offer(new Edge(1, 0));
        int total = 0;
        while(!queue.isEmpty()){
            Edge current = queue.poll();
            if(visited[current.getTo()]) continue;
            total += current.getDist();
            visited[current.getTo()] = true;
            for(int next : map.get(current.getTo()).keySet()){
                if(visited[next]) continue;
                queue.offer(new Edge(next, map.get(current.getTo()).get(next)));
            }
        }
        return total;
    }

    static class Edge{
        int from;
        int to;
        int dist;

        public int getFrom(){
            return this.from;
        }

        public Edge(int to, int dist){
            this.to = to;
            this.dist = dist;
        }

        public int getDist(){
            return this.dist;
        }

        public int getTo(){
            return this.to;
        }
    }
}
