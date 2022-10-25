import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] radix = new int[5][5];
        for(int i=0; i<5; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<5; j++){
                radix[i][j] = Integer.parseInt(arr[j]);
            }
        }
        int[] nums = new int[8];
        for(int i=0; i<8; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(new Solution().solution(radix, nums));
    }
}