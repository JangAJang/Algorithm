import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String word = br.readLine();
        boolean[][] isPalindrom = checkPalindrom(word);
        int[] dp = new int[word.length()+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 1; j <= i; j++) {
                if (isPalindrom[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }
        System.out.println(dp[word.length()]);
    }

    private static boolean[][] checkPalindrom(String word){
        boolean[][] check = new boolean[word.length()+1][word.length()+1];
        for(int start = 1; start <= word.length(); start++){
            for(int end = start; end <= word.length(); end++){
                check[start][end] = isFlag(word, start-1, end-1);
            }
        }
        return check;
    }

    private static boolean isFlag(String word, int start, int end){
        while(start <= end){
            if(word.charAt(start++) != word.charAt(end--))
                return false;
        }
        return true;
    }
}