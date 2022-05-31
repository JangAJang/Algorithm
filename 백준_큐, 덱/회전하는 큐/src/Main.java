import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=T; i++){
            deque.add(i);
        }
        int numbers = Integer.parseInt(st.nextToken());
        int count = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<numbers; i++){
            int x = Integer.parseInt(st.nextToken());
            int location = 0;
            for(int j=0; j<deque.size(); j++){
                if( x == (int)deque.toArray()[j]) location = j;
            }
            if(location <= deque.size()/2){
                while(deque.getFirst() != x){
                    deque.addLast(deque.pollFirst());
                    count++;
                }
                deque.removeFirst();
            }
            else{
                while(deque.getFirst() != x){
                    deque.addFirst(deque.pollLast());
                    count++;
                }
                deque.removeFirst();
            }
        }
        System.out.println(count);
    }
}