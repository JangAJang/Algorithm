import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr1;
    static int[][] arr2;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void getArray(int a, int b, int[][] arr)throws IOException{
        st  =new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[a][b];
        for(int i=0; i<a; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<b; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args)throws IOException {
        int n = 0, m= 0, k= 0;
        getArray(n, m, arr1);
        getArray(m, k, arr2);
        int[][] arr3 = new int[n][k];

    }
}
