import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long[][] price;
    static int N;
    static int Bus;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Bus = Integer.parseInt(br.readLine());
        price = new long[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j ) price[i][j] = 0;
                else price[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<Bus; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if(price[s][e] > p) price[s][e] = p;
        }
        FloydWarshall();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(price[i][j] == Integer.MAX_VALUE) price[i][j] = 0;
                bw.write(price[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void FloydWarshall(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(price[i][k] + price[k][j] < price[i][j]){
                        price[i][j] = price[i][k] + price[k][j];
                    }

                }
            }
        }
    }
}
