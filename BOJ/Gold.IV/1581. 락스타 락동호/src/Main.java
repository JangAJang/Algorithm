import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int ff, fs, sf, ss;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        ff = Integer.parseInt(st.nextToken());
        fs = Integer.parseInt(st.nextToken());
        sf = Integer.parseInt(st.nextToken());
        ss = Integer.parseInt(st.nextToken());
        System.out.println(ans());
    }

    private static int ans() {
        if (ff == 0 && fs == 0) return ss + Math.min(sf, 1);
        if (fs == 0) return ff;
        int changeTempo = getChangeTempo();
        return ff + ss + changeTempo;
    }

    private static int getChangeTempo() {
        if (fs > sf) return 2 * sf + 1;
        return 2 * fs;
    }
}