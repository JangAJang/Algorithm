import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n % 2 == 1){
            System.out.println("0");
            return;
        }
        List<Long> dp = new ArrayList<>();
        dp.add(0L);
        dp.add(0L);
        dp.add(3L);
        for(int index = 3; index <= n; index ++){
            if(index % 2 == 1){
                dp.add(0L);
                continue;
            }
            long value = 0L;
            value += 3* dp.get(index-2);
            for(int next = index - 4; next >=0; next -=2){
                value += 2 * dp.get(next);
            }
            value += 2L;
            dp.add(value);
        }
        System.out.println(dp.get(n));
    }
}