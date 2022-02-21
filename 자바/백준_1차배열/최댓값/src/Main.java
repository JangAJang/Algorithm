import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int point=0, max=0;
        int[] array = new int [9];
        for(int i=0; i<9; i++){
            array[i] = Integer.parseInt(br.readLine());
            if(max < array[i]) {
                max = array[i];
                point = i+1;
            }
        }
        System.out.println(max + "\n" + point);
    }
}
