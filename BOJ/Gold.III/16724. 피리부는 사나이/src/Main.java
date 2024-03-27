import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Gold3. 16724. 피리부는 사나이
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[][] visited;
    private static char[][] arr;
    private static Map<int[], int[]> parent;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        parent = new HashMap<>();
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        visited = new boolean[X][Y];
        arr = new char[X][Y];

        for(int index = 0; index < X; index++) {
            arr[index] = br.readLine().toCharArray();
        }

        for(int x = 0; x < X; x++) {
            for(int y = 0; y < Y; y++) {
                if(visited[x][y]) continue;
                dfs(x, y);
            }
        }

        Set<int[]> set = new HashSet<>(parent.values());
        System.out.println(set.size());
    }

    private static int[] find(int[] point) {
        int[] found = parent.getOrDefault(point, point);
        if(pointEquals(point, found)) return point;
        parent.put(point, find(found));
        return parent.get(point);
    }

    private static void union(int[] a, int[] b) {
        a = find(a);
        b = find(b);
        if(pointEquals(a, b)) return;
        parent.put(getBigger(a, b), getSmaller(a, b));
    }

    private static int[] getSmaller(int[] a, int[] b) {
        if(a[0] != b[0]) return a[0] < b[0] ? a : b;
        return a[1] < b[1] ? a : b;
    }

    private static int[] getBigger(int[] a, int[] b) {
        if(a[0] != b[0]) return a[0] < b[0] ? b : a;
        return a[1] < b[1] ? b : a;
    }

    private static boolean pointEquals(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    private static void dfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        int[] start = new int[]{x, y};
        queue.offer(start);
        while(!queue.isEmpty()) {
            int[] current = queue.pop();
            int currentX = current[0];
            int currentY = current[1];
            if(visited[currentX][currentY]) continue;
            visited[currentX][currentY] = true;
            int[] next = findNextMove(current);
            union(start, next);
            queue.offer(next);
        }
    }

    private static int[] findNextMove(int[] current) {
        int x = current[0];
        int y = current[1];
        if(arr[x][y] == 'D') {
            return new int[]{x+1, y};
        }

        if(arr[x][y] == 'R') {
            return new int[]{x, y+1};
        }

        if(arr[x][y] == 'L') {
            return new int[]{x, y-1};
        }

        return new int[]{x-1, y};
    }
}