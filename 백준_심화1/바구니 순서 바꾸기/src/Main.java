import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    private static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());
        makeBasket(count);
        int cases = Integer.parseInt(st.nextToken());
        while(cases-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());
            rotate(start, end, mid);
        }
        StringBuilder sb = new StringBuilder();
        for(int index = 1; index <= count; index++){
            sb.append(array[index]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void rotate(int start, int end, int mid){
        List<Integer> list = new ArrayList<>();
        for(int index = mid; index <= end; index++){
            list.add(array[index]);
        }
        for(int index = start; index <= mid-1; index++){
            list.add(array[index]);
        }
        for(int index = start; index <= end; index++){
            array[index] = list.get(index-start);
        }
    }

    private static void makeBasket(int count){
        array = new int[count+1];
        for(int index = 1; index <= count; index++){
            array[index] = index;
        }
    }
}