import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Double> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            double x = Long.parseLong(br.readLine());
            if( x == 0 ) {
                if(queue.isEmpty()) System.out.println(0);
                else{
                    double num = queue.poll();
                    if(num == (long)num) System.out.println((long)num);
                    else{
                        System.out.println(((long)num+1)*(-1));
                    }
                }
            }
            else if(x>0){
                queue.add(x);
            }
            else{
                double x_abs = Math.abs(x) - 0.001;
                queue.add(x_abs);
            }
        }

    }
}
