import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken()), A;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A = Integer.parseInt(st.nextToken());
            if(A < X) bw.write(A + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
