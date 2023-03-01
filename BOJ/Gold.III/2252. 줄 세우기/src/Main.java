import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        IntStream.range(1, n+1).forEach(i -> map.put(i, new ArrayList<>()));
        while(m-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            map.get(front).add(back);
            arr[back]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        IntStream.range(1, n+1).forEach(i -> {
            if( arr[i] == 0) queue.add(i);
        });
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int current = queue.poll();
            visited[current] = true;
            sb.append(current).append(" ");
            for(int next : map.get(current)){
                if(visited[next]) continue;
                arr[next]--;
                if(arr[next] == 0) queue.add(next);
            }
        }
        System.out.println(sb.toString());
    }
}