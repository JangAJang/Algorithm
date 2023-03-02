import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] arr = new int[21][21][21];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a=0, b=0, c=0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a= Integer.parseInt(st.nextToken());
        b= Integer.parseInt(st.nextToken());
        c= Integer.parseInt(st.nextToken());
        while(true){
            if(a==-1 && b==-1 && c==-1){
                break;
            }
            else {
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int w(int a, int b, int c){
        if(a <=0 || b<=0 || c <=0) return 1;
        if(a>20 || b>20 || c > 20) return w(20, 20, 20);
        if(arr[a][b][c] != 0) return arr[a][b][c];
        if(a==b && b==c) {
            arr[a][b][c] = (int) Math.pow(2, a);
            return arr[a][b][c];
        }
        if(a<b && b<c) {
            arr[a][b][c] = w(a, b, c-1) +w(a, b-1, c-1)-w(a, b-1, c);
            return arr[a][b][c];
        }
        arr[a][b][c]=w(a-1, b, c)+w(a-1, b-1, c)+w(a-1, b, c-1)-w(a-1, b-1, c-1);
        return arr[a][b][c];
    }
}
