import java.util.*;

public class Solution {

    public int solution(int v, int[][] edges){
        PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2)->o1.getDist() - o2.getDist());
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[v+1];
        for(int index = 1; index <=v;index++){
            map.put(index, new HashMap<>());
        }
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int dist = edge[2];
            map.get(from).put(to, dist);
            map.get(to).put(from, dist);
        }
        queue.offer(new Edge(1, 0));
        int total = 0;
        while(!queue.isEmpty()){
            Edge current = queue.poll();
            if(visited[current.getNode()]) continue;
            total += current.getDist();
            visited[current.getNode()] = true;
            for(int next : map.get(current.getNode()).keySet()){
                if(visited[next]) continue;
                queue.add(new Edge(next, map.get(current.getNode()).get(next)));
            }
        }
        return total;
    }

    static class Edge{
        int node;
        int dist;

        public Edge(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        public int getDist(){
            return this.dist;
        }

        public int getNode(){
            return this.node;
        }
    }
}
