import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {


    static int[][] dp = new int[1001][1001];
    static String[] n1;
    static String[] n2;

    public static void main(String[] args) throws IOException{


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n1 = br.readLine().split("");
        n2 = br.readLine().split("");
        String ans = solve();

        bw.write(ans.length() + "\n");
        if(ans.length()!=0 ) bw.write(ans + "\n");


        bw.flush();
        bw.close();
    }




    public static String solve() {

        // 테이블 그리기
        for(int i=0; i<n1.length; i++) {
            for(int j=0; j<n2.length; j++) {
                if(n1[i].equals(n2[j])) {
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        int x = n1.length;
        int y = n2.length;
        String a = "";
        while(x!=0 && y!=0) {

            if(n1[x-1].equals(n2[y-1])) {
                a +=n1[x-1];
            }

            if(dp[x-1][y] == dp[x][y]) {
                x-=1;
            } else if(dp[x][y-1] == dp[x][y]) {
                y-=1;
            } else {
                x-=1;
                y-=1;
            }
        }

        String ans = "";
        for(int i=a.length()-1; i>=0; i--) {
            ans += a.charAt(i);
        }


        return ans;

    }




}