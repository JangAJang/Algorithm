import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 0;
        for(int k=0; k<T; k++){
        String S = br.readLine();
        boolean checker = true;
        for(int i=0; i<S.length(); i++){
            for(int j=0; j<S.length(); j++){
                if(S.charAt(i) == S.charAt(j)){
                    if(Math.abs(i-j) > 1 ) checker = false;}}}
        if(checker == true) count++;
        }
        System.out.println(count);
    }
}