import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    private static int diagram = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solution();
    }

    private static class Solution{

        public void solution()throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int nodeCount = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[nodeCount+1];
            for(int index = 1; index <= nodeCount; index++){
                int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                nodes[split[0]] = new Node();
                for(int count = 1; count < split.length-1; count += 2){
                    int next = split[count];
                    int distance = split[count+1];
                    nodes[split[0]].addNext(next, distance);
                }
            }
            for(int index = 1; index <= nodeCount; index++){
                diagram = Math.max(bfs(index, nodes, new boolean[nodeCount+1]), diagram);
            }
            System.out.println(diagram);
        }
        private int bfs(int start, Node[] nodes, boolean[] visited){
            int[] distance = new int[visited.length];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[start] = 0;
            distance[0] = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(start);
            while(!queue.isEmpty()){
                int current = queue.poll();
                visited[current] = true;
                for(int next : nodes[current].getNextNodes()){
                    distance[next] = Math.min(distance[current] + nodes[current].getDistanceTo(next), distance[next]);
                    if(visited[next]) continue;
                    queue.add(next);
                    visited[next] = true;
                }
            }
            Arrays.sort(distance);
            return distance[distance.length-1];
        }

        class Node{
            private final HashMap<Integer, Integer> map = new HashMap<>();

            public Node() {}

            public void addNext(int next, int dist){
                map.put(next, dist);
            }

            public Set<Integer> getNextNodes(){
                return map.keySet();
            }

            public int getDistanceTo(int nextNode){
                return map.get(nextNode);
            }
        }
    }
}