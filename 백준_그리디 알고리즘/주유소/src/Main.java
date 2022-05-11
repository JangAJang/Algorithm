import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] road = new long[N-1];
        long[] town = new long[N];
        long tank = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N-1; i++){
            road[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            town[i] = Long.parseLong(st.nextToken());
        }
        long result = road[0]*town[0];
        int now = 0;
        int next = now+1;
        while(next < N - 1){
            if(town[now] < town[next]){
                result += town[now]+road[next];
            }
            else{
                result += town[next]*road[next];
                now = next;
            }
            next++;
        }
        System.out.println(result);
    }
}
