import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeIndex {
    // lv0. 인덱스 바꾸기
    class Solution {
        public String solution(String my_string, int num1, int num2) {
            List<String> stringList = Arrays.stream(my_string.split("")).collect(Collectors.toList());
            Collections.swap(stringList, num1, num2);
            return String.join("", stringList);
        }
    }
}
