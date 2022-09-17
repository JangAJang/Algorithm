import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int nums = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int[] arr = new int[nums];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<nums; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0, end = 0, count = 0;
        int total = arr[start];
        while(start <= end && end < nums && start < nums){
            if(total == sum) count++;
            if(total >= sum){
                total = total - arr[start];
                start++;
            }
            else {
                end++;
                if(end < nums){
                    total = total + arr[end];
                }
            }
        }
        System.out.println(count);
    }
}
