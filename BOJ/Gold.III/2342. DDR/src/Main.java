import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final List<Integer> route = new ArrayList<>();
    private static int[][][] dp;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        addInputs();
        dp = new int[route.size()][5][5];
        System.out.println(dfs(0, 0, 0));
    }

    private static int dfs(int index, int left, int right) {
        if(index == route.size()) {
            return 0;
        }

        if(dp[index][left][right] != 0)
            return dp[index][left][right];

        int goLeft = dfs(index + 1, route.get(index), right) + going(left, route.get(index));
        int goRight = dfs(index + 1, left, route.get(index)) + going(right, route.get(index));
        dp[index][left][right] = Math.min(goLeft, goRight);
        return dp[index][left][right];
    }

    private static int going(int start, int end) {
        if(start == 0) return 2;
        else if(Math.abs(start - end) == 2) return 4;
        else if(start == end) return 1;
        else return 3;
    }

    private static void addInputs() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int value = Integer.parseInt(st.nextToken());
        while(value != 0) {
            route.add(value);
            value = Integer.parseInt(st.nextToken());
        }
    }
}