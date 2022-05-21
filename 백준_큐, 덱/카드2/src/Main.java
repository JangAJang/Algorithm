import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            q.add(i);
        }
        while( q.size()>1){
            q.remove();
            int tmp = q.poll();
            q.add(tmp);
        }
        System.out.println(q.peek());
    }
}
