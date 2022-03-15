import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine(), b = br.readLine();
        int[][] arr = new int[a.length()+1][b.length()+1];
        for(int i=0; i<=a.length(); i++){
            arr[i][0] = 0;
        }
        for(int i=0; i<=b.length(); i++){
            arr[0][i] = 0;
        }
        int max = 0;
        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if(b.charAt(j-1) == a.charAt(i-1)) arr[i][j] = arr[i-1][j-1]+1;
                else arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                max = Math.max(max, arr[i][j]);
            }
        }
        System.out.println(max);
    }
}
