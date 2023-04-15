import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];
        for(int index = 0; index < n; index++){
            ropes[index] = Integer.parseInt(br.readLine());
        }
        ropes = Arrays.stream(ropes).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        for(int index = 0; index < n; index++){
            ropes[index] *= (index+1);
        }
        System.out.println(Arrays.stream(ropes).max().getAsInt());
    }
}