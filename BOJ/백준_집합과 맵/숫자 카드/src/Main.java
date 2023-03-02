import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int checker(int[] arr, int start, int end, int check){
        if(start == end){
            if(arr[start] != check) return 0;
            else return 1;
        }
        else{
            int half = (start+end)/2;
            if( check > arr[half]){
                return checker(arr, half+1, end, check);
            }
            else if(check < arr[half]){
                return checker(arr, start, half, check);
            }
            else{
                return 1;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            int check = Integer.parseInt(st.nextToken());
            int result = checker(arr, 0, arr.length-1, check);
            bw.write(result+" ");
        }
        bw.flush();
    }
}
