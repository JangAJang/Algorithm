import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map = new int[x][y];
        visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean flag = true;
        int time = 0;
        int firstCount = getCount();
        while (flag) {
            time++;
            bfs(new Location(0, 0));
            for (int i = 0; i < x; i++)
                Arrays.fill(visited[i], false);
            int count = getCount();

            if (count == 0)
                flag = false;
            else
                list.add(count);
        }
        System.out.println(time);
        if (list.size() > 0) {
            System.out.println(list.get(list.size() - 1));
            return;
        }
        System.out.println(firstCount);
    }

    static void bfs(Location location) {

        Queue<Location> queue = new LinkedList<>();
        queue.add(location);
        visited[location.x][location.y] = true;

        while (!queue.isEmpty()) {
            Location current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length) {
                    if (!visited[newX][newY]) {
                        if (map[newX][newY] == 1) {
                            map[newX][newY] = 2;
                            visited[newX][newY] = true;
                        }
                        if (map[newX][newY] == 0) {
                            visited[newX][newY] = true;
                            queue.add(new Location(newX, newY));
                        }
                    }
                }
            }
        }
        removeCheese();
    }

    static void removeCheese() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2)
                    map[i][j] = 0;
            }
        }
    }

    static int getCount() {

        int count = 0;

        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                if (ints[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x= x;
            this.y = y;
        }
    }
}