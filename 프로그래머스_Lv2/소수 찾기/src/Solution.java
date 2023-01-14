import java.util.*;
import java.util.stream.Collectors;

class Solution {

    private final Set<Integer> cases = new HashSet<>();
    private boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        for(int index = 1; index <= numbers.length(); index++){
            dfs(numbers.substring(index-1).split(""), "", 0);
        }
        List<Integer> primes = getPrimesUntil(cases.stream().sorted().collect(Collectors.toUnmodifiableList()).get(cases.size()-1));
        int count = 0;
        for(int each: cases){
            if(primes.contains(each)) {
                System.out.println(each);
                count++;
            }
        }
        return count;
    }

    private void dfs(String[] split, String value, int count){
        if(count == split.length) {
            cases.add(Integer.parseInt(value));
            return;
        }
        for(int index = 0; index < split.length; index++){
            if(!visited[index]){
                visited[index] = true;
                dfs(split, value+split[index], count+1);
                visited[index] = false;
            }
        }
    }

    private List<Integer> getPrimesUntil(int value){
        List<Integer> numbers = new ArrayList<>();
        for(int index = 2; index <=value; index++){
            if(isPrime(index)) numbers.add(index);
        }
        return numbers;
    }

    private boolean isPrime(int number){
        for(int index = 2; index <= Math.sqrt(number); index++){
            if(number % index == 0) return false;
        }
        return true;
    }
}