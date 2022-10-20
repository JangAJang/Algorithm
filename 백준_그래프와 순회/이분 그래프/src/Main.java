import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static BufferedReader br;
    static int V, E;
    static List<Integer>[] edges;
    static int[] visit;

    public static void main(String[] args)throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            solveProblem();
            if(isThisBipartite()) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static void solveProblem()throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new ArrayList[V+1];
        visit = new int[V+1];
        for(int i=1; i<=V; i++){
            edges[i] = new ArrayList<>();
        }
        getGraph();
    }

    public static void getGraph()throws IOException{
        for(int i=0; i<E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges[start].add(end);
            edges[end].add(start);
        }
    }

    public static boolean isThisBipartite(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        visit[1] = 1;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0; i<edges[now].size(); i++){
                if(visit[edges[now].get(i)] == 0){
                    queue.add(edges[now].get(i));
                    visit[edges[now].get(i)] = visit[now] * -1;
                }
                if(visit[now] == visit[edges[now].get(i)]) return false;
            }
        }
        return true;
    }
}