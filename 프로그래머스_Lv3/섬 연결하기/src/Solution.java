import java.util.*;

class Solution {

    private int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int index = 0; index < n; index++){
            parent[index] = index;
        }
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        int result = 0;
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int size = cost[2];
            if (find(a) != find(b)) {
                union(a, b);
                result += size;
            }
        }
        return result;
    }

    private int find(int a){
        if(parent[a] == a) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
}