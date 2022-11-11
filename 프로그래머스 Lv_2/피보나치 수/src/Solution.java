import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<Integer> fibonacciNumbers = new ArrayList<>();

    public int solution(int n) {
        return getFibonacciNumberOfIndex(n);
    }

    private int getFibonacciNumberOfIndex(int n){
        initializeFibonacci();
        makeFibonacci(n);
        return fibonacciNumbers.get(n);
    }

    private void initializeFibonacci(){
        fibonacciNumbers.addAll(List.of(0, 1));
    }

    private void makeFibonacci(int n){
        for(int index = 2; index <=n; index++){
            int nextNumber = fibonacciNumbers.get(index-1)+fibonacciNumbers.get(index-2);
            fibonacciNumbers.add(nextNumber % 1234567);
        }
    }
}