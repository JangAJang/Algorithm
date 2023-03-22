import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][3];
        Arrays.fill(arr[0], 0);
        for(int index = 1; index <=n; index++){
            arr[index] = Arrays.copyOf(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray(), 3);
        }
        getMaxMovement(n, 1, arr, new int[n+1][3]);
        getMinMovement(n, 1, arr, new int[n+1][3]);
        System.out.println(max + " " + min);
    }

    private static void getMaxMovement(int n, int count, int[][] arr, int[][] dp){
        for(int index = 0; index < 3; index++){
            if(index == 0){
                dp[count][index] = Math.max(dp[count-1][index], dp[count-1][index+1])  + arr[count][index];
                continue;
            }
            if(index == 2){
                dp[count][index] = Math.max(dp[count-1][index], dp[count-1][index-1])  + arr[count][index];
                continue;
            }
            dp[count][index] = Math.max(Math.max(dp[count-1][index], dp[count-1][index-1]), dp[count-1][index+1])
                    + arr[count][index];
        }
        if(n == count){
            max = Math.max(Arrays.stream(dp[n]).max().getAsInt(), max);
            return;
        }
        getMaxMovement(n, count+1, arr, dp);
    }

    private static void getMinMovement(int n, int count, int[][] arr, int[][] dp){
        for(int index = 0; index < 3; index++){
            if(index == 0){
                dp[count][index] = Math.min(dp[count-1][index], dp[count-1][index+1])  + arr[count][index];
                continue;
            }
            if(index == 2){
                dp[count][index] = Math.min(dp[count-1][index], dp[count-1][index-1])  + arr[count][index];
                continue;
            }
            dp[count][index] = Math.min(Math.min(dp[count-1][index], dp[count-1][index-1]), dp[count-1][index+1])
                            + arr[count][index];
        }
        if(n == count){
            min = Math.min(Arrays.stream(dp[n]).min().getAsInt(), min);
            return;
        }
        getMinMovement(n, count+1, arr, dp);
    }
}