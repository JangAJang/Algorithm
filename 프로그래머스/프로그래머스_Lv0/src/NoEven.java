import java.util.*;

public class NoEven {
    //lv0. 짝수는 싫어요
    class Solution {
        public int[] solution(int n) {
            return getOdds(n);
        }

        private int[] getOdds(int n){
            List<Integer> numbers = new ArrayList<>();
            for(int number = 1; number <= n; number += 2){
                numbers.add(number);
            }
            return numbers.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
