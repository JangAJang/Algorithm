import java.io.*;
import java.util.*;
import java.util.stream.*;

//실버 4 1158. 요세푸스 문제
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new ArrayDeque<>();
        IntStream.range(1, n+1).forEach( i -> queue.offer(i));
        StringBuilder sb = new StringBuilder("<");
        while(queue.size() != 1) {
            for(int index = 1; index < count; index++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb.toString());
    }
}