import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long max = 3000000000L;
    private static long[] result = new long[3];

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        for(int x = 0; x < n-2; x++){
            binarySearch(arr, x);
        }
        Arrays.sort(result);
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, 3).forEach(i -> sb.append(result[i]).append(" "));
        System.out.println(sb.toString());
    }

    private static void binarySearch(long[] arr, int start){
        int left = start+1;
        int right = arr.length-1;
        while(left < right){
            long sum = arr[left] + arr[right] + arr[start];
            long absSum = Math.abs(sum);
            if(absSum < max) {
                result[0] = arr[left];
                result[1] = arr[right];
                result[2] = arr[start];
                max = absSum;
            }

            if(sum > 0) {
                right--;
                continue;
            }
            left++;
        }
    }
}