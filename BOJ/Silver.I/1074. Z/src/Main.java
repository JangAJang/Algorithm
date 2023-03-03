import java.util.*;
import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int[][] order = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int count = 0;
        int val = (int)Math.pow(2, n);
        while(val > 1){
            val /=2;
            int tmp = 0;
            int x = r / val;
            int y = c / val;
            for(int index = 0; index < 4; index++){
                if(x == order[index][0] && y == order[index][1]) {
                    tmp = index;
                    break;
                }
            }
            count += tmp * val* val;
            r %= val;
            c %= val;
        }
        System.out.println(count);
    }
}