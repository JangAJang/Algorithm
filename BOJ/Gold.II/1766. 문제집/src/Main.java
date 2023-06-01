import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, List<Integer>> nodes = new HashMap<>();
        int[] state = new int[n+1];
        boolean[] visited = new boolean[n+1];
        IntStream.range(1, n+1).forEach( i -> nodes.put(i, new ArrayList<>()));
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            nodes.get(first).add(next);
            state[next]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for( int index = 1; index <=n; index++) {
            if(state[index] == 0) pq.offer(index);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int current = pq.poll();
            if(visited[current]) continue;
            visited[current] = true;
            sb.append(current).append(" ");
            for(int next : nodes.get(current)) {
                state[next]--;
                if(state[next] == 0) pq.offer(next);
            }
        }
        System.out.println(sb.toString());
    }
}