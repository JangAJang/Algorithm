import java.util.*;
import java.util.stream.*;
import java.io.*;


public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int numbers = Integer.parseInt(st.nextToken());
        int cases = Integer.parseInt(st.nextToken());
        List<List<Integer>> edges = new ArrayList<>();
        IntStream.range(0, numbers+1).forEach(i -> edges.add(new ArrayList<>()));
        int[] degree = new int[numbers+1];
        while(cases-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            for(int next = 1; next < count; next++){
                int singer = Integer.parseInt(st.nextToken());
                edges.get(start).add(singer);
                degree[singer]++;
                start = singer;
            }
        }
        System.out.println(topologicalSort(edges, degree, numbers));
    }

    private static String topologicalSort(List<List<Integer>> edges, int[] degree, int numbers){
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for(int index = 1; index <= numbers; index++){
            if(degree[index] == 0) queue.add(index);
        }
        while(!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);
            for(int next : edges.get(current)){
                degree[next]--;
                if(degree[next] == 0) queue.add(next);
            }
        }
        if(result.size() != numbers) return "0";
        StringBuilder sb = new StringBuilder();
        for(int singer : result){
            sb.append(singer).append("\n");
        }
        return sb.toString();
    }
}