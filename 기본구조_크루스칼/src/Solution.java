import java.util.*;
import java.util.stream.*;

public class Solution {

    private int[] parent;
    private int total = 0;

    public void solution(int n, int[][] edges){
        Arrays.sort(edges, Comparator.comparingInt(o1-> o1[2]));
        parent = new int[n+1];
        IntStream.range(1, n+1).forEach(i-> parent[i] = i);
        for(int[] edge : edges){
            
        }
    }

    private void union(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a > b) {
            parent[a] = b;
            return;
        }
        parent[b] = a;
    }

    private int getParent(int n){
        if(parent[n] == n) return n;
        return parent[n] = getParent(parent[n]);
    }
}
