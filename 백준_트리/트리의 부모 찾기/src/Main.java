import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    private static final Solution solution = new Solution();

    public static void main(String[] args) throws Exception{
        solution.solution();
    }

    private static class Solution{

        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private int[] parents;

        private void solution()throws Exception {
            int nodes = Integer.parseInt(br.readLine());
            parents = new int[nodes+1];
            HashMap<Integer, List<Integer>> map = makeMapTo(nodes);
            StringTokenizer st;
            for(int index = 0; index < nodes-1; index++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                map.get(start).add(end);
                map.get(end).add(start);
            }
            dfs(map, new boolean[nodes+1]);
            for(int index = 2; index <= nodes; index++){
                System.out.println(parents[index]);
            }
        }

        private void dfs(HashMap<Integer, List<Integer>> map, boolean[] visited){
            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            while(!stack.isEmpty()){
                int current = stack.pop();
                visited[current] = true;
                for(int next : map.get(current)){
                    if(visited[next]) continue;
                    parents[next] = current;
                    stack.push(next);
                }
            }
        }

        private HashMap<Integer, List<Integer>> makeMapTo(int nodes){
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int index = 1; index <= nodes; index++){
                map.put(index, new ArrayList<>());
            }
            return map;
        }
    }
}