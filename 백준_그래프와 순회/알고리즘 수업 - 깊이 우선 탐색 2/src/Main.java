import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int[] vertex;
    static int count=1;
    static int[] visited;
    static ArrayList<Integer> edge[];
    static int r;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        edge = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            edge[i] = new ArrayList<>();
        }
        vertex = new int[n+1];
        visited = new int[n+1];
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edge[start].add(end);
            edge[end].add(start);
        }
        for(int i=1; i<=n; i++){
            edge[i].sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o2 > o1) return 1;
                    else return -1;
                }
            });
        }
        dfs(r);
        for(int i=1; i<=n; i++){
            System.out.println(visited[i]);
        }
    }

    static void dfs(int r){
        visited[r] = count++;
        for(int x : edge[r]){
            if(visited[x] > 0) continue;
            dfs(x);
        }
    }
}
