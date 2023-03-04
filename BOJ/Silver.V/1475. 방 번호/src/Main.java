import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int max = 0;
        for(int number : Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray()){
            if(number == 9) {
                arr[6]++;
                continue;
            }
            arr[number]++;
        }
        if(arr[6] % 2 != 0){
            arr[6] = arr[6] / 2 + 1;
        }
        else arr[6] /= 2;
        for(int n : arr){
            max = Math.max(n, max);
        }
        System.out.println(max);
    }
}