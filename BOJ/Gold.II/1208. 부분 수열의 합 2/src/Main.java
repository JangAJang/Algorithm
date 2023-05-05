import java.io.*;
import java.util.*;

//1208. 부분수열의 합 2(gold.2)
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int index = 0; index < n; index++){
            arr[index] = Integer.parseInt(st.nextToken());
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        getPossibleSums(0, 0, n/2, left);
        getPossibleSums(0, n/2, n, right);
        Collections.sort(left);
        Collections.sort(right);
        long answer = countAnswer(left, right, target);
        if(target == 0) answer --;
        System.out.println(answer);
    }

    private static long countAnswer(List<Integer> left, List<Integer> right, int target){
        long count = 0;
        int leftIndex = 0;
        int rightIndex = right.size()-1;
        while(leftIndex < left.size() && rightIndex >= 0) {
            int leftValue = left.get(leftIndex);
            int rightValue = right.get(rightIndex);
            int sumValue = leftValue + rightValue;
            if(sumValue == target) {
                long cntL = 0;
                long cntR = 0;
                while(leftIndex < left.size() && leftValue == left.get(leftIndex)) {
                    cntL++;
                    leftIndex++;
                }
                while(rightIndex >= 0 && rightValue == right.get(rightIndex)) {
                    cntR++;
                    rightIndex--;
                }
                count += cntL*cntR;
            }
            if( sumValue < target) {
                leftIndex++;
            }
            if(sumValue > target){
                rightIndex--;
            }
        }
        return count;
    }

    private static void getPossibleSums(int sum, int start, int end, List<Integer> list){
        if(start == end) {
            list.add(sum);
            return;
        }
        getPossibleSums(sum, start+1, end, list);
        getPossibleSums(sum + arr[start], start+1, end, list);
    }
}