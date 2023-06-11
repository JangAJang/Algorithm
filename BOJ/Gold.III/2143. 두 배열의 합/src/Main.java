import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int count = 0;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] a = getInputArray();
        int[] sumA = getAccumulatedSum(n, a);
        int m = Integer.parseInt(br.readLine());
        int[] b = getInputArray();
        int[] sumB = getAccumulatedSum(m, b);
        int[] shorter = sumA;
        int[] longer = sumB;
        if(sumA.length > sumB.length) {
            longer = sumA;
            shorter = sumB;
        }
        HashMap<Integer, Boolean> madeByA = checkMadeByA(shorter);
        countMadeSum(T, longer, madeByA);
        System.out.println(count);
    }

    private static HashMap<Integer, Boolean> checkMadeByA(int[] sumA) {
        HashMap<Integer, Boolean> madeByA = new HashMap<>();
        for(int index = 1; index < sumA.length; index++) {
            for(int start = 0; start < index; start++) {
                int partialSum = sumA[index] - sumA[start];
                madeByA.put(partialSum, true);
            }
        }
        return madeByA;
    }

    private static void countMadeSum(int T, int[] sumB, HashMap<Integer, Boolean> madeByA) {
        for(int index = 1; index <sumB.length; index++) {
            for(int start = 0; start < index; start++) {
                int partialSum = sumB[index] - sumB[start];
                if(madeByA.getOrDefault(T - partialSum, false)) count++;
            }
        }
    }

    private static int[] getInputArray()throws IOException{
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[] getAccumulatedSum(int n, int[] arr) {
        int[] result = new int[n+1];
        IntStream.range(1, n+1).forEach(i -> result[i] += arr[i-1] + result[i-1]);
        return result;
    }
}