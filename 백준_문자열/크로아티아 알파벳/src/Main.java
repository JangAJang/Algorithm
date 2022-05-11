import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String croa[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(int i=0; i<croa.length; i++){
            if(S.contains(croa[i])) S = S.replace(croa[i], "!");
        }
        System.out.println(S.length());
    }
}
