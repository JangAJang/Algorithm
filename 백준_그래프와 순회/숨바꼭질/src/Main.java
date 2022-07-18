import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] check;
    static Queue<Integer> cases;
    static int least = Integer.MAX_VALUE;
    static int sister;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        check = new boolean[100001];
        cases = new ArrayDeque<>();
        int subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());
        cases.add(subin);
        bfs(-1, subin);
        System.out.println(least);
    }

    static void bfs(int count, int location){
        check[location] = true;
        if(location >= sister){
            least = Math.min(count, least);
            return;
        }
        else{
            int[] arr = {location+1, location-1, location*2};
            for(int i=0; i<3; i++){
                if(arr[i] >=0 && arr[i] <= 100000){
                    if(!check[arr[i]]){
                        bfs(count+1, arr[i]);
                    }
                }
            }
        }
        check[location] = false;
    }
}
