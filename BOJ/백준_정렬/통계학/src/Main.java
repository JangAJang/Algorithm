import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int [T], count = new int [8001];
        int max = -4000, min = 4000;
        double sum = 0;
        for(int i=0; i<T; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) max = arr[i];
            if(min > arr[i]) min = arr[i];
            sum += arr[i];
            count[arr[i]+4000]++;
        }
        Arrays.sort(arr);
        int counted = 0;
        for(int i=0; i<8001; i++){
            if(counted < count[i]) counted = count[i];
        }
        for(int i=0; i<8001; i++){
            if(counted == count[i]) list.add(i-4000);
        }
        System.out.println(Math.round(sum/T));
        System.out.println(arr[T/2]);
        if(list.size()==1) System.out.println(list.get(0));
        else {Collections.sort(list);System.out.println(list.get(1));}
        System.out.println(max-min);
    }
}