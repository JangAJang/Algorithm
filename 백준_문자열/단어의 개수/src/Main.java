import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int count=0;
        if(S.charAt(0) == ' ') count--;
        if(S.charAt(S.length()-1) == ' ') count--;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == ' ') count++;
        }
        count++;
        System.out.println(count);
    }
}
