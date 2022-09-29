import java.io.*;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            if(hashMap.containsKey(x)){
                hashMap.put(x, hashMap.get(x)+1);
            }
            else hashMap.put(x, 1);
        }
        Stack<Integer> tmp = new Stack<>();
        Stack<Integer> result = new Stack<>();
        for(int i=N-1; i>=0; i--){
            if(!tmp.isEmpty() && hashMap.get(tmp.peek()) > hashMap.get(arr[i])){
                result.push(tmp.peek());
                tmp.push(arr[i]);
            }
            else if(!tmp.isEmpty() && hashMap.get(tmp.peek()) <= hashMap.get(arr[i])){
                while( !tmp.isEmpty() && hashMap.get(tmp.peek()) <= hashMap.get(arr[i])){
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
