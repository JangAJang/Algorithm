import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static int hashing(String s, HashMap<String, Integer> map, int location){
        if(location == s.length()) return 0;
        String tmp = "";
        for(int i=location; i<s.length(); i++){
            tmp += Character.toString(s.charAt(i));
            if(!map.containsKey(tmp)){
                map.put(tmp, 1);
            }
        }
        return hashing(s, map, location+1);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        HashMap<String, Integer> map = new HashMap<>();
        hashing(s, map, 0);
        System.out.println(map.size());
    }
}
