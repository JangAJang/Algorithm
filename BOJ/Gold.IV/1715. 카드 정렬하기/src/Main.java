import java.util.*;
import java.io.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        PriorityQueue<Long> cards = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            cards.offer(Long.parseLong(br.readLine()));
        }
        if(cards.size() == 1){
            System.out.println(0);
            return;
        }
        long count = 0L;
        while(cards.size() > 1){
            for(int index = 0; index < cards.size()/2; index++){
                long value = cards.poll() + cards.poll();
                count += value;
                cards.offer(value);
            }
        }
        System.out.println(count);
    }
}