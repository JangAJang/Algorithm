import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int site = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        int findPasswords = Integer.parseInt(st.nextToken());
        while(site-- > 0){
            String[] code = br.readLine().split(" ");
            map.put(code[0], code[1]);
        }
        while(findPasswords-- > 0){
            bw.write(map.get(br.readLine())+"\n");
        }
        bw.flush();
    }
}