import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void getCount(int[][] arr, String s){
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<26; j++){
                arr[i][j] = arr[i-1][j];
            }
            int num = s.charAt(i-1) - 'a';
            arr[i][num]++;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[][] arr = new int[s.length()+1][26];
        getCount(arr, s);
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(arr[end+1][x] - arr[start][x]);
        }
    }
}
