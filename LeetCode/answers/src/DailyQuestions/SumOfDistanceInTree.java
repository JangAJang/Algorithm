package DailyQuestions;
import java.util.*;

public class SumOfDistanceInTree {

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] childCount = new int[n];
        int[] subtreeSum = new int[n];
        int[] result = new int[n];

        dfsCount(0, -1, graph, childCount);
        dfsSum(0, -1, graph, childCount, subtreeSum);

        result[0] = subtreeSum[0];
        dfsResult(0, -1, graph, childCount, subtreeSum, result);

        return result;
    }

    private void dfsCount(int node, int parent, List<List<Integer>> graph, int[] childCount) {
        int count = 1;
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                dfsCount(neighbor, node, graph, childCount);
                count += childCount[neighbor];
            }
        }
        childCount[node] = count;
    }

    private void dfsSum(int node, int parent, List<List<Integer>> graph, int[] childCount, int[] subtreeSum) {
        int totalSum = 0;
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                dfsSum(neighbor, node, graph, childCount, subtreeSum);
                totalSum += subtreeSum[neighbor] + childCount[neighbor];
            }
        }
        subtreeSum[node] = totalSum;
    }

    private void dfsResult(int node, int parent, List<List<Integer>> graph, int[] childCount, int[] subtreeSum, int[] result) {
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                result[neighbor] = result[node] - childCount[neighbor] + (childCount.length - childCount[neighbor]);
                dfsResult(neighbor, node, graph, childCount, subtreeSum, result);
            }
        }
    }
}
