import java.util.*;
import java.util.stream.*;

class Solution {

    public int[] solution(int n, long k) {int[] answer = new int[n];
        List<Integer> factorialList = new ArrayList<>();
        long factorial = 1;
        for(int i=1; i<=n; i++) {
            factorialList.add(i);
            factorial *= i;
        }
        k--;
        int index = 0;
        while(index < n) {
            factorial /= n - index;
            answer[index++] = factorialList.remove((int) (k / factorial));
            k %= factorial;
        }
        return answer;
    }
}