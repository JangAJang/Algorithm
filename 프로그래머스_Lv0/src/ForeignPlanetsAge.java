import java.util.Arrays;

public class ForeignPlanetsAge {
    // lv0. 외계행성의 나이
    class Solution {
        public String solution(int age) {
            StringBuilder ageBuilder = new StringBuilder();
            Arrays.stream(Integer.toString(age).split(""))
                    .forEach(s-> ageBuilder.append((char)(Integer.parseInt(s)+'a')));
            return ageBuilder.toString();
        }
    }
}
