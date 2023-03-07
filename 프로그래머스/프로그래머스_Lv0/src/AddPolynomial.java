import java.util.Arrays;
import java.util.regex.Pattern;

public class AddPolynomial {
    // lv0. 다항식 더하기
    class Solution {
        public String solution(String polynomial) {
            int coefficient = Arrays.stream(polynomial.split(" "))
                    .filter(s-> s.contains("x"))
                    .mapToInt(s-> {
                        if(s.equals("x")) return 1;
                        return Integer.parseInt(s.split("")[0]);
                    }).sum();
            int constant = Arrays.stream(polynomial.split(" ")).filter(s-> Pattern.matches("^[0-9]$", s))
                    .mapToInt(Integer::parseInt).sum();
            if(constant == 0) return (coefficient)+"x";
            return (coefficient)+"x + " + (constant);
        }
    }
}
