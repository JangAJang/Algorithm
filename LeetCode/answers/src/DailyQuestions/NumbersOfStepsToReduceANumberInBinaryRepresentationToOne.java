package DailyQuestions;

import java.math.*;

public class NumbersOfStepsToReduceANumberInBinaryRepresentationToOne {

    public int numSteps(String s) {
        int count = 0;
        BigInteger value = new BigInteger(s, 2);
        while(!value.equals(BigInteger.ONE)) {
            count++;
            if(value.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                value = value.divide(BigInteger.TWO);
                continue;
            }

            value = value.add(BigInteger.ONE);
        }
        return count;
    }
}
