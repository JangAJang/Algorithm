import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  T= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] array = new int [T];
        int i=0;
        while(st.hasMoreTokens()){
            array[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(array);
        System.out.println(array[0] + " " + array[T-1]);
    }
}
