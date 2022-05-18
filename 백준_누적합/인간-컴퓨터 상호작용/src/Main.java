import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j=start; j<=end; j++){
                if(s.charAt(j) == c ){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

