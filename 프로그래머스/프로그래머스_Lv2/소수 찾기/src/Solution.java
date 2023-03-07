import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {

    private final Set<Integer> primes = new HashSet<>();
    private boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        addPrimes(numbers, "");
        System.out.println(primes.toString());
        return primes.size();
    }

    private void addPrimes(String numbers, String madeNumber){
        for(int index = 0; index < numbers.length(); index++){
            if(!visited[index]){
                visited[index] = true;
                addIfPrime(madeNumber + numbers.charAt(index));
                addPrimes(numbers, madeNumber + numbers.charAt(index));
                visited[index] = false;
            }
        }
    }

    private void addIfPrime(String madeNumber){
        int value = Integer.parseInt(madeNumber);
        if(value == 0 || value == 1) return;
        if(value == 2 || value == 3) {
            primes.add(value);
            return;
        }
        for(int index = 2; index <= Math.sqrt(value); index++){
            if(value % index == 0) return;
        }
        primes.add(value);
    }
}