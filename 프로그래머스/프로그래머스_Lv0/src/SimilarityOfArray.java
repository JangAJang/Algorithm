import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimilarityOfArray {
    //lv0. 배열의 유사도
    class Solution {
        public int solution(String[] s1, String[] s2) {
            int count = 0;
            List<String> comparator = Arrays.stream(s2).collect(Collectors.toList());
            for(String s1Each : s1){
                count+= countIfContaining(s1Each, comparator);
            }
            return count;
        }

        private int countIfContaining(String s1Each, List<String> comparator){
            if(containsWord(s1Each, comparator)) return 1;
            return 0;
        }

        private boolean containsWord(String word, List<String> s2){
            return s2.contains(word);
        }
    }
}
