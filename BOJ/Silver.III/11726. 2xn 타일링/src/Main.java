import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        int n = Integer.parseInt(br.readLine());
        for(int index = 3; index <= n; index++){
            list.add((list.get(index-1)+list.get(index-2))%10007);
        }
        System.out.println(list.get(n));
    }
}