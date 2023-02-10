import java.util.*;

class Solution {

    private HashMap<Integer, Set<Integer>> map;

    public int solution(int n, int[][] wires) {
        createGraph(n,wires);
        int result = Integer.MAX_VALUE;
        for(int[] wire : wires){
            result = Math.min(result, Math.abs(n - 2 * countNode(wire)));
        }
        return result;
    }

    private void createGraph(int n, int[][] wires){
        map = new HashMap<>();
        for(int index = 1; index <=n; index++){
            map.put(index, new HashSet<>());
        }
        for(int[] wire : wires){
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }
    }

    private int countNode(int[] wire){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[map.keySet().size()+1];
        stack.add(1);
        while(!stack.isEmpty()){
            int current = stack.pop();
            addNextStations(wire, current, visited, stack);
            visited[current] = true;
        }
        return countVisits(visited);
    }

    private int countVisits(boolean[] visited){
        int result = 0;
        for(boolean visit : visited){
            if(visit) result++;
        }
        return result;
    }

    private void addNextStations(int[] wire, int current, boolean[] visited, Stack<Integer> stack){
        for(int next : map.get(current)){
            if(!visited[next] && !isSkip(wire, new int[]{current, next})){
                stack.push(next);
                visited[next] = true;
            }
        }
    }

    private boolean isSkip(int[] wire, int[] currentWire) {
        return (wire[0] == currentWire[0] && wire[1] == currentWire[1]) ||
                (wire[1] == currentWire[0] && wire[0] == currentWire[1]);
    }
}