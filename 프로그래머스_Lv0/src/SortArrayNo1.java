import java.util.Arrays;
import java.util.regex.Pattern;

public class SortArrayNo1 {
    //lv0. 문자열 정렬하기(1)
    class Solution {
        public int[] solution(String my_string) {
            return Arrays.stream(my_string.split("")).filter(s-> Pattern.matches("^[0-9]*$", s))
                    .mapToInt(Integer::parseInt).sorted().toArray();
        }
    }
}
