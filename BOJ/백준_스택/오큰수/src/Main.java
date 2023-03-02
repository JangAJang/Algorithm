import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] arg)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> tmp = new Stack<>();
        Stack<Integer> result = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=N-1; i>=0; i--){
            if(!tmp.isEmpty() && tmp.peek() > arr[i]){
                result.push(tmp.peek());
                tmp.push(arr[i]);
            }
            else if(!tmp.isEmpty() && tmp.peek() <= arr[i]){
                while( !tmp.isEmpty() && tmp.peek() <= arr[i]){
                    tmp.pop();
                }
                if(tmp.isEmpty()) {
                    result.push(-1);
                    tmp.push(arr[i]);
                }
                else{
                    result.push(tmp.peek());
                    tmp.push(arr[i]);
                }
            }
            else{
                result.push(-1);
                tmp.push(arr[i]);
            }
        }
        for(int i=0; i<N; i++){
            int temp = result.pop();
            bw.write(temp+" ");
        }
        bw.flush();
    }
}
