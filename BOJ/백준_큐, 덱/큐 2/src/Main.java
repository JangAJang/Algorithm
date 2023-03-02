import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()){
                case "push" :
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;

                case "pop" :
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.poll());
                    break;

                case "size" :
                    System.out.println(q.size());
                    break;

                case "empty" :
                    if(q.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;

                case "front" :
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.getFirst());
                    break;

                case "back" :
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.getLast());
                    break;
            }

        }
    }
}
