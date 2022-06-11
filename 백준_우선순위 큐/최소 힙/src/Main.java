import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            long x = Long.parseLong(br.readLine());
            if( x == 0 ) {
                if(queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }
            else{
                queue.add(x);
            }
        }

    }
}
