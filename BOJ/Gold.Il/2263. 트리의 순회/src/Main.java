import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] in, post, pre;
    static int idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        pre = new int[n];
        in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        post = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        getPreOrder(0, n - 1, 0, n - 1);
        for (int n : pre) bw.write(n + " ");
        bw.flush();
    }

    public static void getPreOrder(int is, int ie, int ps, int pe) {
        if (is <= ie && ps <= pe) {
            pre[idx++] = post[pe];
            int pos = is;
            for (int i = is; i <= ie; i++) {
                if (in[i] == post[pe]) {
                    pos = i;
                    break;
                }
            }
            getPreOrder(is, pos - 1, ps, ps + pos - is - 1);
            getPreOrder(pos + 1, ie, ps + pos - is, pe - 1);
        }
    }
}