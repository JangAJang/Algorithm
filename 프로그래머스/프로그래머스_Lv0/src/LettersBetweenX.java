import java.util.Arrays;

public class LettersBetweenX {
    class Solution {
        public int[] solution(String myString) {
            int[] res = Arrays.stream((myString+" ").split("x")).mapToInt(String::length).toArray();
            res[res.length-1]--;
            return res;
        }
    }
}
