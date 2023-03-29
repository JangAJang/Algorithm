import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            Solution solution = new Solution();
            solution.solution();
        }
    }

    static class Solution {
        private char[][] map;
        private boolean[] key;
        private ArrayList<Point>[] gates;
        private boolean[][] visited;
        private int h;
        private int w;
        private static final int[] dx = {-1, 1, 0, 0};
        private static final int[] dy = {0, 0, -1, 1};
        private int count;

        public void solution() throws IOException{
            String[] inputMap = br.readLine().split(" ");
            h = Integer.parseInt(inputMap[0]);
            w = Integer.parseInt(inputMap[1]);
            map = new char[h + 2][w + 2];
            visited = new boolean[h + 2][w + 2];
            key = new boolean[26];
            gates = new ArrayList[26];
            count = 0;
            initializeMap();
            addKey();
            bfs();
            System.out.println(count);
        }

        private void initializeMap()throws IOException{
            for (int i = 0; i < 26; i++) {
                gates[i] = new ArrayList<>();
            }
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    map[i][j] = '.';
                }
            }
            for (int i = 1; i <= h; i++) {
                String input = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = input.charAt(j - 1);
                }
            }
        }

        private void addKey() throws IOException{
            String keyInput = br.readLine();
            if (!keyInput.equals("0")) {
                for (int i = 0; i < keyInput.length(); i++) {
                    int temp = keyInput.charAt(i) - 'a';
                    key[temp] = true;
                }
            }
        }

        private boolean isDoor(int elem){
            return elem - 'A' >= 0 && elem - 'A' <= 25;
        }

        private boolean isKey(int elem){
            return elem - 'a' >= 0 && elem - 'a' <= 25;
        }

        private boolean containsKey(int elem){
            return key[elem - 'A'];
        }

        private void bfs() {
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(0, 0));
            visited[0][0] = true;
            while (!q.isEmpty()) {
                Point p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2) continue;
                    if (map[nx][ny] == '*' || visited[nx][ny]) continue;
                    int elem = map[nx][ny];
                    if (isDoor(elem)) {
                        if (containsKey(elem)) {
                            map[nx][ny] = '.';
                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny));
                            continue;
                        }
                        gates[elem - 'A'].add(new Point(nx, ny));
                        continue;
                    }
                    if (isKey(elem)) {
                        key[elem - 'a'] = true;
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                        for (int j = 0; j <= 25; j++) {
                            if (gates[j].size() != 0 && key[j]) {
                                for (int z = 0; z < gates[j].size(); z++) {
                                    Point temp = gates[j].get(z);
                                    map[temp.x][temp.y] = '.';
                                    visited[temp.x][temp.y] = true;
                                    q.add(new Point(temp.x, temp.y));
                                }
                            }
                        }
                        continue;
                    }
                    if (elem == '$') {
                        count++;
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                        continue;
                    }
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}