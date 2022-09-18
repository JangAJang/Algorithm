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
        int[] arr = new int[nums+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<nums; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int total = 0;
        while(start <= nums && end <= nums){
            if(total >= sum && min > end - start) min = end - start;
            if(total < sum) total += arr[end++];
            else total -= arr[start++];
        }
        if(min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);
    }
}
