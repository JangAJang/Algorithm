import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<A; i++){
            map.put(Integer.parseInt(st.nextToken()), 1);
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<B; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(map.containsKey(tmp))map.remove(tmp);
            else{
                map.put(tmp, 1);
            }
        }
        System.out.println(map.size());
    }
}
