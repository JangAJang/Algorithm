import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, Integer> dfsmap;
    static HashMap<Integer, Integer> bfsmap;

    static int[] vertex_dfs;
    static int[] vertex_bfs;
    static int countDFS = 1;
    static int countBFS = 1;
    static ArrayList<Integer> edge[];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        vertex_dfs = new int[n+1];
        vertex_bfs = new int[n+1];
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
        dfsmap = new HashMap<>();
        bfsmap = new HashMap<>();
        DFS(v);
        BFS(v);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=1; i<=n; i++){
           if( dfsmap.get(i) != null ) sb1.append(dfsmap.get(i)+" ");
           if( bfsmap.get(i) != null ) sb2.append(bfsmap.get(i)+" ");
        }
        System.out.println(sb1);
        System.out.println(sb2);
    }

    static void DFS(int r){
        vertex_dfs[r] = countDFS++;
        if(dfsmap.containsValue(r)){
            dfsmap.remove(vertex_dfs[r]);
        }
        dfsmap.put(vertex_dfs[r], r);
        for(int x : edge[r]){
            if(vertex_dfs[x] > 0 ) continue;
            DFS(x);
        }
    }

    static void BFS(int r){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(r);
        vertex_bfs[r] = countBFS++;
        if(bfsmap.containsValue(r)){
            bfsmap.remove(vertex_bfs[r]);
        }
        bfsmap.put(vertex_bfs[r], r);
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int i : edge[x]){
                if(vertex_bfs[i] > 0) continue;
                queue.add(i);
                vertex_bfs[i] = countBFS++;
                if(bfsmap.containsValue(i)){
                    bfsmap.remove(vertex_bfs[i]);
                }
                bfsmap.put(vertex_bfs[i], i);
            }
        }
    }
}
