import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortStringNo2 {
    // lv0. 문자열 정렬하기(2)
    class Solution {
        public String solution(String my_string) {
            List<String> sorted = Arrays.stream(my_string.toLowerCase().split("")).sorted().collect(Collectors.toList());
            return String.join("", sorted);
        }
    }
}
