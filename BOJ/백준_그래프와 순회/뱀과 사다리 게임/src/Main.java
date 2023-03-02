import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] SnL;
    static boolean[] visit;
    public static void main(String[] args)throws IOException{
        arr = new int [101];
        SnL = new int[101];
        visit = new boolean[101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ladder  = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());
        for(int i=0; i<ladder + snake; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            SnL[from] = to;
        }
        bfs();
    }

    static void bfs(){
        Queue<Integer> queue = new ArrayDeque<>();
        arr[1] = 0;
        visit[1] =  true;
        queue.add(1);
        while(!queue.isEmpty()){
            int x = queue.poll();
            if(x == 100){
                System.out.println(arr[x]);
                return;
            }
            for(int i=1; i<=6; i++){
                int tmp = x + i;
                if(100<tmp) continue;
                if(visit[tmp])continue;
                visit[tmp] = true;
                if(SnL[tmp] != 0){
                    if(!visit[SnL[tmp]]){
                        queue.add(SnL[tmp]);
                        visit[SnL[tmp]] = true;
                        arr[SnL[tmp]] = arr[x]+1;
                    }
                }
                else{
                    queue.add(tmp);
                    arr[tmp] = arr[x]+1;
                }
            }
        }
    }

}
