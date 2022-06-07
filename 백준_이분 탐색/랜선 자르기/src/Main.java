import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //UpperBound를 사용한 이분탐색, 탐색시 배열에서 이분탐색을 진행하는 것이 아닌 길이의 값을 이분탐색한다.

    static int n;
    static int k;
    static long[] arr;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new long[k];
        long max = 0;
        for(int i=0; i<k; i++){
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(arr[i], max);
        }
        max++;
        long min = 0;
        long mid = 0;
        while(min<max){
            long count = 0;
            mid = (min+max)/2;
            for(int i=0; i<arr.length; i++){
                count += (arr[i]/mid);
                if(count < n) {
                    max = mid;
                }
                else {
                    min = mid + 1;
                }
            }
        }
        System.out.println(min-1);
    }
}
