import java.util.ArrayList;
import java.util.List;

public class PrimeDividance {
    // lv0. 소인수분해
    class Solution {
        public int[] solution(int n) {
            List<Integer> primes = new ArrayList<>();
            for(int index = 2; index <=n; index++){
                if(isPrime(index) && n % index == 0) primes.add(index);
            }
            return primes.stream().sorted().mapToInt(Integer::intValue).toArray();
        }

        private boolean isPrime(int number){
            int count = 0;
            for(int index = 1; index <= Math.sqrt(number); index++){
                if(number % index == 0) count++;
            }
            return count == 1;
        }
    }
}
