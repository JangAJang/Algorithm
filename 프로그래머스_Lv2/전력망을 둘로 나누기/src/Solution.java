import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int result = Integer.MAX_VALUE;
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int index = 1; index <=n; index++){
            map.put(index, new HashSet<>());
        }
        for(int[] wire : wires){
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }
        for(int[] wire : wires){
            result = Math.min(result, Math.abs(n - 2 * countNode(map, wire)));
        }
        return result;
    }

    private int countNode(HashMap<Integer, Set<Integer>> map, int[] wire){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[map.keySet().size()+1];
        stack.add(1);
        while(!stack.isEmpty()){
            int current = stack.pop();
            visited[current] = true;
            for(int next : map.get(current)){
                if(!visited[next] && !isSkip(wire, current, next)){
                    stack.push(next);
                    visited[next] = true;
                }
            }
        }
        int result = 0;
        for(boolean visit : visited){
            if(visit) result++;
        }
        return result;
    }

    private boolean isSkip(int[] wire, int current, int next) {
        return (wire[0] == current && wire[1] == next) ||
                (wire[1] == current && wire[0] == next);
    }
}