import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int[] i = new int[100], r = new int[100], q = new int[100], x = new int[100], y = new int[100];
        i[0] = -1;
        r[0] = a;
        x[0] = 1;
        y[0] = 0;
        i[1] = 0;
        r[1] = b;
        x[1] = 0;
        y[1] = 1;
        for(int k=0; k<2; k++){
            System.out.println("i("+k+"): " + i[k] + ", r(" + k + "): " + r[k]
                    + ", q(" + k + "): " + q[k]+ ", x(" + k + "): " + x[k]+ ", y(" + k + "): " + y[k]);
        }
        for(int k=2; k<100; k++){
            r[k] = r[k-2]%r[k-1];
            q[k] = r[k-2]/r[k-1];
            x[k] = x[k-2] - q[k]*x[k-1];
            y[k] = y[k-2] - q[k]*y[k-1];
            i[k] = k-1;
            if(r[k] == 0) System.out.println("i("+k+"): " + i[k] + ", r(" + k + "): " + r[k]);
            else System.out.println("i("+k+"): " + i[k] + ", r(" + k + "): " + r[k]
                    + ", q(" + k + "): " + q[k]+ ", x(" + k + "): " + x[k]+ ", y(" + k + "): " + y[k]);
        }

    }
}
