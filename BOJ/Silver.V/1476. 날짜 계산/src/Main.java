import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 1;
        while(true){
            if(count % 15 == arr[0]%15 && count % 28 == arr[1]%28 && count % 19 == arr[2]%19){
                System.out.println(count);
                return;
            }
            count++;
        }
    }
}