import java.util.Arrays;
import java.util.stream.Collectors;

public class DeleteDuplicatedCharacter {
    // lv0. 중복된 문자 제거
    class Solution {
        public String solution(String my_string) {
            return my_string.chars().mapToObj(Character::toString).distinct().toString();
        }
    }
}
