import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int counter=0;
    static int N;
    static int[] arr;
    static int[] calc = new int[4];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++){
            calc[i] = Integer.parseInt(st.nextToken());
        }
        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int index){
        if(index == N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return ;
        }

        for(int i=0; i<4; i++){
            if(calc[i] >0){
                calc[i]--;
                switch(i){
                    case 0 : dfs(num + arr[index], index+1); break;
                    case 1 : dfs(num - arr[index], index+1); break;
                    case 2 : dfs(num * arr[index], index+1); break;
                    case 3 : {
                        if(num < 0) dfs( -1*((-1*num ) / arr[index]), index+1);
                        else dfs(num / arr[index], index+1);
                    }
                }
                calc[i]++;
            }
        }
    }
}
