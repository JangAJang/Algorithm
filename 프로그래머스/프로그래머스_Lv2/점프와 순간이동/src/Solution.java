import java.util.*;

public class Solution {

    private int count = 0;

    public int solution(int n) {
        return moveBackToZero(n);
    }

    private int moveBackToZero(int n){
        if(n == 0) return count;
        if(isEven(n)) {
            return moveBackToZero(divideHalf(n));
        }
        return moveBackToZero(minusOne(n));

    }

    private boolean isEven(int n){
        return n%2 == 0;
    }

    private int divideHalf(int n){
        return n/2;
    }

    private int minusOne(int n){
        count++;
        return n-1;
    }
}