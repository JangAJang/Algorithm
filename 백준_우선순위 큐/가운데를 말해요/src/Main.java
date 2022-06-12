import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            int x = Integer.parseInt(br.readLine());
            if(queue1.size() == queue2.size()){
                queue2.add(x);
            }
            else queue1.add(x);
            if(!queue1.isEmpty() && !queue2.isEmpty()){
                if(queue2.peek() > queue1.peek()){
                    int tmp = queue1.poll();
                    queue1.add(queue2.poll());
                    queue2.add(tmp);
                }
            }
            bw.write(queue2.peek() + "\n");
        }
        bw.flush();
    }
}
