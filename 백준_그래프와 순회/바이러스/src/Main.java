import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> wire[];
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int con = Integer.parseInt(br.readLine());
        wire = new ArrayList[computer+1];
        visited = new boolean[computer+1];
        for(int i=1; i<=computer; i++){
            wire[i] = new ArrayList<>();
        }
        for(int i=1; i<=con; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            wire[start].add(end);
            wire[end].add(start);
        }
        dfs(1);
        System.out.println(count);
    }

    static void dfs(int r){
        visited[r] = true;
        for(int x : wire[r]){
            if(visited[x]) continue;
            count++;
            dfs(x);
        }
    }
}
