import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = 0;
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            parseCommand(str);
        }
        System.out.println(sb);
    }

    private static void parseCommand(final String str) {
        if(str.equals("all")){
            S = (1 << 21) - 1;
            return;
        }
        if(str.equals("empty")) {
            S = 0;
            return;
        }
        int num = Integer.parseInt(st.nextToken());
        if(str.equals("add")){
            S |= (1 << num);
            return;
        }
        if(str.equals("remove")) {
            S &= ~(1 << num);
            return;
        }

        if(str.equals("check")) {
            sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
            return;
        }
        S ^= (1 << num);
    }
}