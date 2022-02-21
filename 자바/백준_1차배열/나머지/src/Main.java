import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[10];
        for(int i=0; i<10; i++){
            array[i] = Integer.parseInt(br.readLine()) % 42;
        }
        Arrays.sort(array);
        int count=0;
        for(int i=0; i<10; i++){
            if( i==0 ) count++;
            else if(array[i] != array[i-1]) count++;
        }
        System.out.println(count);
    }
}
