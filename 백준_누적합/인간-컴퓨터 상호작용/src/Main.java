import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[][] arr = new int[s.length()+1][26];
        for(int i=1; i<=s.length(); i++){
            int tmp = s.charAt(i-1)-'a';
            for(int j=0; j<26; j++){
                arr[i][j] = arr[i-1][j];
            }
            arr[i][tmp]++;
        }
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int c = st.nextToken().toCharArray()[0] - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            System.out.println(arr[r+1][c] - arr[l][c]);
        }
    }
}
