import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Silver2. 1182 부분 수열의 합
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int count = 0;
    private static int sum;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        sum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int index = 0; index < n; index++) {
            arr[index] = Integer.parseInt(st.nextToken());
        }

        countSum(new boolean[n], arr, 0, 0);
        System.out.println(count);
    }

    private static void countSum(boolean[] visited, int[] arr, int accumulated, int start) {
        for(int index = start; index < arr.length; index++) {
            if(visited[index]) {
                continue;
            }
            if(arr[index] + accumulated == sum) {
                count++;
            }
            visited[index] = true;
            countSum(visited, arr, accumulated + arr[index], index+1);
            visited[index] = false;
        }
    }
}