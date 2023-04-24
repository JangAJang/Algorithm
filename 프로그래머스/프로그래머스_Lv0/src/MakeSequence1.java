import java.util.*;
import java.util.stream.*;

public class MakeSequence1 {
    class Solution {
        public int[] solution(int[] arr) {
            return Arrays.stream(arr).boxed().mapToInt(this::convertValue).toArray();
        }

        private int convertValue(int value){
            if(value >= 50 && value % 2 == 0){
                return value /2;
            }
            if(value < 50 && value % 2 != 0){
                return value *2;
            }
            return value;
        }
    }
}
