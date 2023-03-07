import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        int count= Integer.parseInt(br.readLine());
        String[] splitted = br.readLine().split(" ");
        for(String s : splitted){
            addToMap(s);
        }
        getResult(br.readLine());
    }

    private static void addToMap(String s){
        if(map.containsKey(s)){
            map.replace(s, map.get(s), map.get(s)+1);
            return;
        }
        map.put(s, 1);
    }

    private static void getResult(String s){
        if(map.containsKey(s)) {
            System.out.println(map.get(s));
            return;
        }
        System.out.println(0);

    }
}