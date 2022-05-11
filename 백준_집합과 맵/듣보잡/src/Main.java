import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            map.put(br.readLine(), 1);
        }
        for(int i=0; i<M; i++){
            String names = br.readLine();
            if(map.containsKey(names)){
                int tmp = map.get(names);
                map.remove(names);
                map.put(names, tmp+1);
                list.add(names);
            }
            else map.put(names, 1);
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
