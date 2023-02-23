import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int basketCount = Integer.parseInt(st.nextToken());
        int works = Integer.parseInt(st.nextToken());
        int[] baskets = makeBaskets(basketCount);
        while(works-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            baskets = flip(start, end, baskets);
        }
        StringBuilder sb = new StringBuilder();
        for(int index =1; index < baskets.length; index++){
            sb.append(baskets[index]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int[] makeBaskets(int basketCount){
        int[] baskets = new int[basketCount+1];
        for(int index = 1; index <= basketCount; index++){
            baskets[index] = index;
        }
        return baskets;
    }

    private static int[] flip(int start, int end, int[] array){
        int[] reverse = Arrays.copyOf(array, array.length);
        for(int a = start, b = end; a <= end; a++, b--){
            reverse[a] = array[b];
        }
        return reverse;
    }
}