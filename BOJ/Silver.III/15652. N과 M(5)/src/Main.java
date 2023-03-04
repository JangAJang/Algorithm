import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] numbers;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        comb(new ArrayList<>(), n, r, 0);
    }

    private static void comb(List<Integer> list, int n, int r, int count){
        if(count == r){
            StringBuilder sb = new StringBuilder();
            for(int value : list) sb.append(value).append(" ");
            System.out.println(sb.toString());
            return;
        }
        for(int i = 0; i < n; i++){
            if(list.contains(numbers[i])) continue;
            list.add(numbers[i]);
            comb(list, n, r, count+1);
            list.remove(list.size()-1);
        }
    }
}