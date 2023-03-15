import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final List<String> combs = new ArrayList<>();
    private static int[] numbers;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        comb(n, m, 0, 0, new StringBuilder());
        for(String combEach : combs){
            System.out.println(combEach);
        }
    }

    private static void comb(int n, int m, int count, int i, StringBuilder sb){
        if(count == m){
            combs.add(sb.toString());
            return;
        }
        for(int index=i; index <n; index++){
            comb(n, m, count+1, index, new StringBuilder(sb).append(numbers[index]).append(" "));
        }
    }
}