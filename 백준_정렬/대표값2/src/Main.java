import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    static int COUNT = 5;
    static long result;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        result = 0;
        for(int i=0; i<COUNT; i++){
            list.add(Integer.parseInt(br.readLine()));
            result += list.get(i);
        }
        getResult(list);
    }

    private static void getResult(List<Integer> list){
        Collections.sort(list);
        System.out.println(result/COUNT);
        System.out.println(list.get(COUNT/2));
    }
}