import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            int x = Integer.parseInt(br.readLine());
            System.out.println(count(x));
        }
    }

    private static int count(int x){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(4);
        for(int index = 4; index <= x; index++){
            list.add(list.get(index-1) + list.get(index-2) + list.get(index-3));
        }
        return list.get(x);
    }
}