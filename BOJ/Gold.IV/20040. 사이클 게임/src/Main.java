import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for(int index = 0; index < n; index++) {
            parent[index] = index;
        }
        System.out.println(getCycledTurn(m));
    }

    private static int getCycledTurn(final int m) throws IOException {
        StringTokenizer st;
        for(int index = 0; index < m; index++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(!union(start, end)) return index + 1;
        }

        return 0;
    }

    private static boolean union(final int a, final int b) {
        int x = find(a);
        int y = find(b);
        if(x != y) {
            parent[y] = x;
            return true;
        }

        return false;
    }

    private static int find(final int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}