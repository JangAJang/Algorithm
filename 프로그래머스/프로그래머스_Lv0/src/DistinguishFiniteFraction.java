import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DistinguishFiniteFraction {
    // lv0. 유한소수 판별하기
    class Solution {

        private final List<Integer> available = List.of(1, 2, 5, 10);

        public int solution(int a, int b) {
            List<Integer> primeDividers = new ArrayList<>();
            int mother = b / getGCD(a, b);
            for(int number = 1; number <= mother; number++){
                if(isPrime(number) && mother % number == 0) primeDividers.add(number);
            }
            System.out.println(primeDividers.toString());
            if(new HashSet<>(available).containsAll(primeDividers)) return 1;
            return 2;
        }

        private boolean isPrime(int value){
            int count = 0;
            for(int number = 1; number <= Math.sqrt(value); number++){
                if(value % number == 0) count++;
            }
            return count == 1;
        }

        private int getGCD(int a, int b){
            int r = Math.max(a, b) % Math.min(a, b);
            if(r == 0) return Math.min(a, b);
            return getGCD(Math.min(a, b), r);
        }
    }
}
