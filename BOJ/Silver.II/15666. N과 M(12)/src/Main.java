import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final List<String> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(n-- > 0){
            map.put(Integer.parseInt(st.nextToken()), 1);
        }
        backTrack(m, 0, new ArrayList<>(), map);
        for(String each : answers){
            System.out.println(each);
        }
    }

    private static void backTrack(int m, int i, List<Integer> made, TreeMap<Integer, Integer> map){
        if(made.size() == m){
            answers.add(toString(made));
            return;
        }
        for(int index = i; index < map.keySet().size(); index++){
            int value = new ArrayList<>(map.keySet()).get(index);
            List<Integer> madeNew = new ArrayList<>(made);
            madeNew.add(value);
            backTrack(m, index, madeNew, map);
        }
    }

    private static String toString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for(int each : list){
            sb.append(each).append(" ");
        }
        return sb.toString();
    }
}