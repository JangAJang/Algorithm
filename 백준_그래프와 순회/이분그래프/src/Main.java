import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int tasks = Integer.parseInt(br.readLine());
        while(tasks-- >0){
            checkBipartite();
        }
    }

    static void checkBipartite()throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Queue<Integer> edges[] = new Queue[V+1];
        for(int i=1; i<=V; i++){
            edges[i] = new ArrayDeque<>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges[start].add(end);
            edges[end].add(start);

        }

    }
}
