import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int distance = Y - X;
            int max = (int)Math.sqrt(distance);
            if(max == Math.sqrt(distance)) {
                sb.append(max * 2 - 1).append('\n');
                continue;
            }
            if(distance <= max * max + max) {
                sb.append(max * 2).append('\n');
                continue;
            }
            sb.append(max * 2 + 1).append('\n');
        }
        System.out.println(sb);
    }
}