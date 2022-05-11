import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String answer = br.readLine();
            char[] arr = answer.toCharArray();
            int total=0;
            int score=0;
            for(int j=0; j<arr.length; j++){
                if(arr[j] == 'O'){++score; total +=score;}
                if(arr[j] == 'X') score = 0;
            }
            System.out.println(total);
        }
    }
}
