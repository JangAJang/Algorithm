import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    private static final Solution solution = new Solution();

    public static void main(String[] args) throws Exception{
        solution.solution();
    }

    private static class Solution{

        public Solution(){}

        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public void solution()throws Exception{
            int size = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[size+1];
            for(int index = 1; index <= size; index++){
                nodes[index] = new Node();
            }
            StringTokenizer st;
            for(int index = 1; index < size; index++){
                st = new StringTokenizer(br.readLine(), " ");
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());
                nodes[parent].addNext(child, distance);
                nodes[child].addNext(parent, distance);
            }
            int start = getMaxOfDistance(getDistancesFrom(1, nodes));
            int[] secondDistance = getDistancesFrom(start, nodes);
            int next = getMaxOfDistance(secondDistance);
            System.out.println(secondDistance[next]);
        }

        private int[] getDistancesFrom(int start, Node[] nodes){
            boolean[] visited = new boolean[nodes.length];
            int[] distance = new int[nodes.length];
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{start, 0});
            while(!stack.isEmpty()){
                int[] current = stack.pop();
                distance[current[0]] = current[1];
                for(int next : nodes[current[0]].getNext()){
                    if(visited[next]) continue;
                    visited[next] = true;
                    stack.push(new int[]{next, current[1] + nodes[current[0]].getNextDistance(next)});
                }
            }
            return distance;
        }

        private int getMaxOfDistance(int[] distance){
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for(int index = 1; index < distance.length; index++){
                if(distance[index] > max) maxIndex = index;
            }
            return maxIndex;
        }

        private class Node{

            private final HashMap<Integer, Integer> edge = new HashMap<Integer, Integer>();

            public Node(){}

            public void addNext(int node, int distance){
                edge.put(node, distance);
            }

            public Set<Integer> getNext(){
                return edge.keySet();
            }

            public int getNextDistance(int next){
                return edge.get(next);
            }
        }
    }
}