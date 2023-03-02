import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0; k<T; k++) {
            int floor = Integer.parseInt(br.readLine()), room = Integer.parseInt(br.readLine());
            int K = floor, N = room;
            int[][] arr = new int[floor + 1][room];
            for (int i = 0; i < room; i++) {
                arr[0][i] = i + 1;
            }
            for (int x = 1; x <= floor; x++) {
                for (int y = 0; y < room; y++) {
                    for (int z = 0; z <= y; z++) {
                        arr[x][y] += arr[x - 1][z];
                    }
                }
            }
            System.out.println(arr[K][N - 1]);
        }
    }
}
