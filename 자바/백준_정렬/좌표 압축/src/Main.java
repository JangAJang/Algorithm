import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] ac = arr.clone();
        Arrays.sort(ac);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;
        for(int i=0; i<N; i++){
            if(!map.containsKey(ac[i])){
                map.put(ac[i], count++);
            }
        }
        for(int i=0; i<N; i++){
            bw.write(map.get(arr[i])+" ");
        }
        bw.flush();
    }
}
