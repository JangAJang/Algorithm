import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int check = 0;
    static int count;
    static int[] arr;
    static int[] tmp;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int length = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[length];
        tmp = new int[length];
        for(int i=0; i<length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(0, length-1);
        if(check < count) System.out.println(-1);
    }

    public static void merge_sort(int start, int end){
        if(start < end){
            int mid = (start+end)/2;
            merge_sort(start, mid);
            merge_sort(mid+1, end);
            int p = start;
            int q = mid + 1;
            int idx = p;
            while (p<=mid || q<=end) {
                if (q>end || (p<=mid && arr[p]<arr[q])) {
                    tmp[idx++] = arr[p++];
                }
                else {
                    tmp[idx++] = arr[q++];
                }
            }
            for (int i=start;i<=end;i++) {
                check++;
                arr[i]=tmp[i];
                if(check == count) System.out.println(arr[i]);
            }
        }
    }

}
