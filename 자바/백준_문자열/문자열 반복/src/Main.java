import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int k=0; k<T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            for (int i = 0; i < S.length(); i++) {
                for (int j = 0; j < R; j++) {
                    bw.write(S.charAt(i));
                }
            }
            bw.flush();
            System.out.printf("\n");
        }
        bw.close();
        br.close();
    }
}
