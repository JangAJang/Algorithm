import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Gold3. 20303. 할로윈의 양아치
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        parent = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int index = 1; index <=N; index++) {
            parent[index] = index;
            arr[index] = Integer.parseInt(st.nextToken());
        }
        for(int index = 0; index < M; index++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(Math.min(a, b), Math.max(a, b));
        }

        Map<Integer, Integer> candyCount = new HashMap<>();
        Map<Integer, Integer> childCount = new HashMap<>();
        for(int index = 1; index <=N; index++) {
            int root = find(index);
            candyCount.put(root, candyCount.getOrDefault(root, 0) + arr[index]);
            childCount.put(root, childCount.getOrDefault(root, 0) + 1);
        }
        System.out.println(knapsack(childCount, candyCount, K));
    }

    private static int knapsack(final Map<Integer, Integer> childCount, final Map<Integer, Integer> candyCount, final int K) {
        int[][] dp = new int[childCount.keySet().size()+1][K];
        List<Integer> rootByChildCount = new ArrayList<>(childCount.keySet());
        rootByChildCount.sort(Comparator.comparingInt(childCount::get));
        for(int x = 1; x <= rootByChildCount.size(); x++) {
            int root = rootByChildCount.get(x-1);
            int children = childCount.get(root);
            for(int y = 1; y < K; y++) {
                if(children > y) {
                    dp[x][y] = dp[x-1][y];
                    continue;
                }
                dp[x][y] = Math.max(dp[x-1][y], dp[x-1][y-children] + candyCount.get(root));
            }
        }
        return dp[rootByChildCount.size()][K-1];
    }

    private static int find(final int a) {
        int parentA = parent[a];
        if(parentA == a) return a;
        return parent[a] = find(parentA);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return;
        parent[b] = a;
    }
}