import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();
        sb.append("<");
        for(int i=1; i<=N; i++){
            q.add(i);
        }
        for(int i=0; i<N-1; i++){
            int tmp;
            for(int j=0; j<M; j++){
                tmp = q.poll();
                if(j!=M-1) q.add(tmp);
                else sb.append(tmp+", ");
            }
        }
        sb.append(q.poll()+">");
        System.out.println(sb);
    }
}
