import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OnlyExistingLetter {
    // lv0. 한 번만 등장하는 문자
    class Solution {
        public String solution(String s) {
            List<String> letters = new ArrayList<>();
            for(String each : s.split("")){
                if(Arrays.stream(s.split("")).filter(letter-> letter.equals(each)).count() == 1) letters.add(each);
            }
            Collections.sort(letters);
            return String.join("", letters);
        }
    }
}
