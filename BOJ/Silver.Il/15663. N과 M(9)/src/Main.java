import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int index = 0; index < n; index++){
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        backTrack(m, map, new ArrayList<>());
        for(String each : result){
            System.out.println(each);
        }
    }

    private static void backTrack(int m, TreeMap<Integer, Integer> map, List<Integer> made){
        if(made.size() == m){
            result.add(toString(made));
        }
        for(int i = 0; i < map.keySet().size(); i++){
            int value = new ArrayList<>(map.keySet()).get(i);
            if(map.get(value) == 0) continue;
            List<Integer> madeNew = new ArrayList<>(made);
            madeNew.add(value);
            map.put(value, map.get(value)-1);
            backTrack(m,map, madeNew);
            map.put(value, map.get(value)+1);
        }
    }

    private static String toString(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for(int each : list){
            sb.append(each).append(" ");
        }
        return sb.toString();
    }
}