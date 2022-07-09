import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int r;
    static ArrayList<Integer> edge[];
    static int[] vertex;
    static int count = 1;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        vertex = new int[n+1];
        edge = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            edge[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edge[start].add(end);
            edge[end].add(start);
        }
        for(int i=1; i<=n; i++){
            edge[i].sort(null);
        }
        bfs(r);
        for(int i=1; i<=n; i++){
            System.out.println(vertex[i]);
        }
    }

    static void bfs(int r){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(r);
        vertex[r] = count++;
        while(!que.isEmpty()){
            int x = que.poll();
            for(int i : edge[x]){
                if(vertex[i] > 0) continue;
                que.add(i);
                vertex[i] = count++;
            }
        }
    }
}
