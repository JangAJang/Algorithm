import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveSeparatedArray {
    // lv0. 잘라서 배열로 저장하기
    class Solution {
        public String[] solution(String my_str, int n) {
            List<String> split = new ArrayList<>();
            for(int index = 0; index < my_str.length()/n; index++){
                split.add(my_str.substring(index*n, (index+1)*n));
            }
            if(my_str.length()%n != 0) split.add(my_str.substring(my_str.length()/n * n));
            return split.toArray(String[]::new);
        }
    }
}
