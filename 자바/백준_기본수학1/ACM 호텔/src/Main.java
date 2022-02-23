import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int floor, room;
        if (N % H == 0) {
            floor = H;
            room = N / H;
        } else {
            floor = N % H;
            room = N / H + 1;
        }
        if (room < 10) System.out.println(floor + "0" + room);
        else System.out.println(floor + "" + room);
        }
    }
}
