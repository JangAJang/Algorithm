import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            checkQueues();
        }
    }

    private static void checkQueues() throws IOException{
        map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            doCommand();
        }
        if(map.isEmpty()){
            System.out.println("EMPTY");
            return;
        }
        System.out.println( map.lastKey() + " " + map.firstKey());
    }

    private static void doCommand() throws IOException{
        String[] splitCommand = br.readLine().split(" ");
        int value = Integer.parseInt(splitCommand[1]);
        if(splitCommand[0].equals("I")){
            map.put(value, map.getOrDefault(value, 0)+1);
            return;
        }
        if(map.size() == 0)
            return;
        int num = value == 1 ? map.lastKey() : map.firstKey();
        if (map.put(num, map.get(num) - 1) == 1)
            map.remove(num);
    }
}