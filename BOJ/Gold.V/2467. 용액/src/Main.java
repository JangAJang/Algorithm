import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] liquids = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer1 = 0;
        int answer2 = 0;
        int value = Integer.MAX_VALUE;
        int left = 0;
        int right = liquids.length-1;
        while(left < right){
            int sum = Math.abs(liquids[left] + liquids[right]);
            if(sum < value){
                value = sum;
                answer1 = left;
                answer2 = right;
            }
            if(sum == 0){
                System.out.println(liquids[left] + " " + liquids[right]);
                return;
            }
            if(liquids[left] + liquids[right] > 0) {
                right--;
                continue;
            }
            left++;
        }
        System.out.println(liquids[answer1] + " " + liquids[answer2]);
    }
}