import java.math.BigInteger;

public class WaysToShareBalls {
    // lv0. 구슬을 나누는 경우의 수
    class Solution{
        public BigInteger solution(int balls, int share) {
            BigInteger num1 = BigInteger.ONE, num2 = BigInteger.ONE;
            long select1 = balls-share > share ? balls-share : share;
            long select2 = balls-share > share? share : balls-share;
            num1 = getFactorial(select1+1, balls);
            num2 = getFactorial(2L, select2);
            return num1.divide(num2);
        }

        private BigInteger getFactorial(long start, long end){
            BigInteger result = BigInteger.ONE;
            for(long index = start; index <= end; index++){
                result  = result.multiply(BigInteger.valueOf(index));
            }
            return result;
        }
    }
}
