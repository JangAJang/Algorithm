import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Solution {

    public int solution(int n, int k) {
        return countPrimes(separateNumbers(makeNominal(n, k)));
    }

    private String makeNominal(int n, int k){
        StringBuilder nominalNumber = new StringBuilder();
        while( n > 0 ){
            nominalNumber.append(n % k);
            n /= k;
        }
        return nominalNumber.reverse().toString();
    }

    private List<String> separateNumbers(String nominalNumber){
        return Arrays.stream(nominalNumber.split("0")).collect(Collectors.toList());
    }

    private int countPrimes(List<String> separated){
        int count = 0;
        for(String each : separated){
            count += checkPrime(each);
        }
        return count;
    }

    private boolean isPrime(int number){
        if(number <=  1) return false;
        for(int index = 2; index <= Math.sqrt(number); index++){
            if(number % index == 0 && number / index != 1) return false;
        }
        return true;
    }

    private int checkPrime(String each){
        if(each.equals("") || !Pattern.matches("^[0-9]*$", each)) return 0;
        if(isPrime(Integer.parseInt(each))) return 1;
        return 0;
    }
}