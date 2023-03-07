import java.util.Arrays;
import java.util.regex.Pattern;

public class BabblingNo1 {
    // lv0. 옹알이(1)
    class Solution {
        public int solution(String[] babbling) {
            return (int) Arrays.stream(babbling).filter(s-> Pattern.matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$", s))
                    .count();
        }
    }
}
