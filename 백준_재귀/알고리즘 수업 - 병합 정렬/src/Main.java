import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long count = 0;
    static long k;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[a];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(arr, 0, arr.length-1);
        if(count > k) System.out.println(-1);
        else System.out.println(count);
    }

    public static void merge_sort(int[] arr, int p, int r){
        if(p < r){
            int q = (p+r)/2;
            merge_sort(arr, p, q);
            merge_sort(arr, q+1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r){
        int i = p, j=q+1, t = 1;
        int[] tmp = new int[arr.length];
        while(i<=q && j <= r){
            if(arr[i] <= arr[j]){
                tmp[t] = arr[i];
                i++;
                t++;
            }
            else{
                tmp[t] = arr[j];
                j++;
                t++;
            }
        }
        while(i<=q){
            tmp[t] = arr[i];
            t++;
            i++;
        }
        while(j<=r){
            tmp[t] = arr[j];
            t++;
            j++;
        }
        i = p;
        t = 1;
        while(i <= r){
            arr[i] = tmp[t];
            int x = tmp[t];
            i++;
            t++;
            count++;
        }
    }
}
