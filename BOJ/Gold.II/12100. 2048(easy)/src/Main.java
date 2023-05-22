import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        int[][] map = new int[n][n];
        StringTokenizer stz;
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(stz.nextToken());
        }
        game(0, map);
        System.out.println(answer);
    }

    public static void game(int count, int[][] map) {
        if(count == 5) {
            findMax(map);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int[][] copy = move(i, map);
            game(count+1, copy);
            for(int a = 0; a < n; a++)
                map[a] = copy[a].clone();
        }
    }

    public static int[][] move(int dir, int[][] map) {
        if(dir == 1)
            return moveUp(map);
        if(dir == 2)
            return moveLeft(map);
        if(dir == 3)
            return moveRight(map);
        return moveDown(map);
    }

    private static int[][] moveUp(int[][] map){
        for(int i = 0; i < n; i++) {
            int index = 0;
            int block = 0;
            for(int j = 0; j < n; j++) {
                if(map[j][i] != 0) {
                    if(block == map[j][i]) {
                        map[index - 1][i] = block * 2;
                        block = 0;
                        map[j][i] = 0;
                        continue;
                    }
                    block = map[j][i];
                    map[j][i] = 0;
                    map[index][i] = block;
                    index++;
                }
            }
        }
        return map;
    }

    private static int[][] moveLeft(int[][] map){
        for(int i = 0; i < n; i++) {
            int index = n - 1;
            int block = 0;
            for(int j = n - 1; j >= 0; j--) {
                if(map[j][i] != 0) {
                    if(block == map[j][i]) {
                        map[index + 1][i] = block * 2;
                        block = 0;
                        map[j][i] = 0;
                        continue;
                    }
                    block = map[j][i];
                    map[j][i] = 0;
                    map[index][i] = block;
                    index--;
                }
            }
        }
        return map;
    }

    private static int[][] moveRight(int[][] map){
        for(int i = 0; i < n; i++) {
            int index = n - 1;
            int block = 0;
            for(int j = n - 1; j >= 0; j--) {
                if(map[i][j] != 0) {
                    if(block == map[i][j]) {
                        map[i][index + 1] = block * 2;
                        block = 0;
                        map[i][j] = 0;
                        continue;
                    }
                    block = map[i][j];
                    map[i][j] = 0;
                    map[i][index] = block;
                    index--;
                }
            }
        }
        return map;
    }

    private static int[][] moveDown(int[][] map){
        for(int i = 0; i < n; i++) {
            int index = 0;
            int block = 0;
            for(int j = 0; j < n; j++) {
                if(map[i][j] != 0) {
                    if(block == map[i][j]) {
                        map[i][index - 1] = block * 2;
                        block = 0;
                        map[i][j] = 0;
                        continue;
                    }
                    block = map[i][j];
                    map[i][j] = 0;
                    map[i][index] = block;
                    index++;
                }
            }
        }
        return map;
    }

    public static void findMax(int[][] map) {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                answer = Math.max(answer, map[i][j]);
    }
}