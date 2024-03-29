import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Platinum5. 2568. 전깃줄 - 2
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st;
        int[][] inputArray = new int[N][2];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine().trim());
            inputArray[n][0] = Integer.parseInt(st.nextToken());
            inputArray[n][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputArray, Comparator.comparingInt(o1 -> o1[0]));
        int[] arr = Arrays.stream(inputArray).mapToInt(o -> o[1]).toArray();
        int[] D = new int[N];
        int[] result = new int[N];
        D[0] = arr[0];
        int size = 1;
        for (int i = 1; i < N; i++) {
            int index = Arrays.binarySearch(D, 0, size, arr[i]);
            index = index >= 0 ? index : Math.abs(index) - 1;
            D[index] = arr[i];
            result[i] = index;
            if (index == size) size++;
        }

        int s = size-1, i = N-1;
        boolean[] vtd = new boolean[N];
        while (s >= 0) {
            if (result[i] == s) {
                vtd[i] = true;
                s--;
            }
            i--;
        }
        int count = 0;
        for (int n = 0; n < N; n++) {
            if (!vtd[n]) {
                count++;
                sb.append(inputArray[n][0]).append("\n");
            }
        }
        System.out.println(count);
        if (count > 0) {
            sb.setLength(sb.length()-1);
            System.out.println(sb);
        }
    }
}