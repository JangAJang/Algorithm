import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        StringTokenizer st;
        for(int index = 0; index < count; index++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{Math.min(a,b), Math.max(a, b)});
        }
        int length = Integer.parseInt(br.readLine());
        list.sort(Comparator.comparingInt(a -> a[1]));
        int lineCount = 0;
        int max = 0;
        for(int[] line : list) {
            while (!pq.isEmpty() && pq.peek() < line[1] - length) {
                pq.poll();
                lineCount--;
            }

            if (line[0] >= line[1] - length) {
                lineCount++;
                pq.add(line[0]);
            }

            max = Math.max(max, lineCount);
        }
        System.out.println(max);
    }
}