import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] numbers = new int [10];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(0);
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int count) throws IOException{
        if(count == M){
            boolean check = true;
            for(int i=0; i<M-1; i++){
                if(numbers[i] > numbers[i+1]) check = false;
            }
            if(check) {
                for (int i = 0; i < M; i++) {
                    bw.write(String.valueOf(numbers[i]) + " ");
                }
                bw.write("\n");
            }
            return ;
        }
        for(int i=1; i<=N; i++){
            numbers[count] = i;
            dfs(count+1);
        }
    }
}