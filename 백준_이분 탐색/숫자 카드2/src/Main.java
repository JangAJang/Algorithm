import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hash = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(hash.containsKey(tmp)){
                int count = hash.get(tmp);
                hash.remove(tmp);
                hash.put(tmp, count+1);
            }
            else{
                hash.put(tmp, 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            int check = Integer.parseInt(st.nextToken());
            if(hash.containsKey(check)){
                bw.write(hash.get(check)+" ");
            }
            else bw.write("0 ");
        }
        bw.flush();
    }
}

