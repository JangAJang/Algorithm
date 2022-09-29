import java.io.*;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=1; i<=N; i++){
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            if(hashMap.containsKey(x)){
                hashMap.put(x, hashMap.get(x)+1);
            }
            else hashMap.put(x, 1);
        }
        for(int i=N; i>=1; i--){
            stack.push(arr[i]);
        }
        for(int i=1; i<=N; i++){
            int x = stack.pop();
            if(stack.isEmpty()) bw.write("-1");
            else{
                int ngf = -1;
                for(int j=i+1; j<=N; j++){
                    if(hashMap.get(arr[j]) > hashMap.get(x)){
                        ngf = arr[j];
                        break;
                    }
                }
                bw.write(ngf + " ");
            }
        }
        bw.flush();
    }
}
