import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    private static Solution solution = new Solution();

    public static void main(String[] args) throws Exception{
        solution.solution();
    }

    static class Solution{

        private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public void solution()throws Exception{
            String s1 = br.readLine();
            String s2 = br.readLine();
            int[][] count = new int[s1.length()+1][s2.length()+1];
            IntStream.range(0, s1.length()+1).forEach(i-> count[i][0] = 0);
            IntStream.range(0, s2.length()+1).forEach(i-> count[0][i] = 0);
            for(int x = 1; x <= s1.length(); x++){
                for(int y = 1; y <= s2.length(); y++){
                    if(s1.charAt(x-1) == s2.charAt(y-1)){
                        count[x][y] = count[x-1][y-1] + 1;
                        continue;
                    }
                    count[x][y] = Math.max(count[x-1][y], count[x][y-1]);
                }
            }
            StringBuilder sb = new StringBuilder();
            int x = s1.length();
            int y = s2.length();
            while(sb.length() < count[s1.length()][s2.length()]){
                if(s1.charAt(x-1) == s2.charAt(y-1)){
                    sb.append(s1.charAt(x-1));
                    x--;
                    y--;
                    continue;
                }
                if(count[x-1][y] > count[x][y-1]){
                    x--;
                    continue;
                }
                y--;
            }
            sb.reverse();
            System.out.println(sb.length());
            System.out.println(sb.toString());
        }
    }
}