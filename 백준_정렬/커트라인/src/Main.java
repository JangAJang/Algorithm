import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int people = Integer.parseInt(st.nextToken());
        int rank = Integer.parseInt(st.nextToken());
        int[] arr = new int[people];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<people; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(arr[people-rank]);
    }
}
