import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int number = Integer.parseInt(st.nextToken());
        int check = Integer.parseInt(st.nextToken())-1;
        List<Integer> list = new ArrayList<>();
        for(int index = 1; index <= number; index++){
            if(number%index ==0) list.add(index);
        }
        if(list.size() <= check) System.out.println(0);
        else System.out.println(list.get(check));
    }
}