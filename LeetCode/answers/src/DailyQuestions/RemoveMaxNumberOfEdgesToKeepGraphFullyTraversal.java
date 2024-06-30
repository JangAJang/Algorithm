package DailyQuestions;

import java.util.*;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversal {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] alice = new int[n+1];
        int[] bob = new int[n+1];

        for(int index = 1; index <= n; index++) {
            alice[index] = index;
            bob[index] = index;
        }

        List<int[]> bothEdge = new ArrayList<>();
        List<int[]> aliceEdge = new ArrayList<>();
        List<int[]> bobEdge = new ArrayList<>();

        for(int[] edge : edges) {
            if(edge[0] == 1) {
                aliceEdge.add(edge);
                continue;
            }

            if(edge[0] == 2) {
                bobEdge.add(edge);
                continue;
            }

            bothEdge.add(edge);
        }

        bothEdge.forEach(edge -> {
            union(edge[1], edge[2], alice);
            union(edge[1], edge[2], bob);
        });

        aliceEdge.forEach(edge -> {
            union(edge[1], edge[2], alice);
        });

        bobEdge.forEach(edge -> {
            union(edge[1], edge[2], bob);
        });

        if(isTraversal(alice) && isTraversal(bob)) {
            int count = 0;
            count += aliceEdge.size() + bothEdge.size() - (n-1);
            count += bobEdge.size() + bothEdge.size() - (n-1);
            return count;
        }

        return -1;
    }

    private boolean isTraversal(int[] arr) {
        for(int index = 1; index < arr.length; index++) {
            if(find(index, arr) != 1) return false;
        }

        return true;
    }

    private int find(int index, int[] arr) {
        if(arr[index] == index) return index;

        return arr[index] = find(arr[index], arr);
    }

    private void union(int a, int b, int[] arr) {
        a = find(a, arr);
        b = find(b, arr);

        if(a == b) return;

        if(a < b) {
            arr[b] = a;
            return;
        }

        arr[a] = b;
    }
}
