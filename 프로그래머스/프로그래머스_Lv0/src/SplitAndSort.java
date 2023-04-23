import java.util.*;
import java.util.stream.*;

public class SplitAndSort {

    class Solution {
        public String[] solution(String myString) {
            List<String> sorted = Arrays.stream(myString.split("x"))
                    .filter(i -> !i.equals("")).sorted().collect(Collectors.toList());
            return toArray(sorted);
        }

        private String[] toArray(List<String> sorted) {
            String[] result = new String[sorted.size()];
            for(int index = 0; index < result.length; index++){
                result[index] = sorted.get(index);
            }
            return result;
        }
    }
}
