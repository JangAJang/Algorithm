import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void getCodi(int n)throws IOException{
        HashMap<String, Integer> map = new HashMap<>();
        int result = 1;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            String part = st.nextToken();
            if(map.containsKey(part)){
                int tmp = map.get(part);
                map.remove(part);
                map.put(part, tmp+1);
            }
            else{
                map.put(part, 1);
            }
        }
        for(int i : map.values()){
            result *= (i+1);
        }
        System.out.println(result-1);
    }

    public static void main(String[] args)throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            getCodi(n);
        }
    }
}
