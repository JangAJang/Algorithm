import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().toUpperCase();
        int[] arr = new int[26];
        char ch = 'A';
        int max = 0;
        for(int i=0; i<S.length(); i++){
            arr[S.charAt(i)-65]++;
            if(max < arr[S.charAt(i)-65]) {max = arr[S.charAt(i)-65]; ch = S.charAt(i);}
            else if(max == arr[S.charAt(i)-65]) ch = '?';
        }
        System.out.println(ch);
    }
}
