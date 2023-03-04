import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed()
                .sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr1);
        int result = 0;
        for(int index = 0; index < n; index++){
            result += arr1[index] * arr2[index];
        }
        System.out.println(result);
    }
}