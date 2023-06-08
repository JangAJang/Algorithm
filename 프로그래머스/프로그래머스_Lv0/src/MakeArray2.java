import java.util.*;

public class MakeArray2 {
    class Solution {
        public int[] solution(int l, int r) {
            List<Integer> list = new ArrayList<>();
            for(int index = l; index <= r; index++) {
                if(Integer.toString(index).replace('5', ' ')
                        .replace('0', ' ').isBlank())
                    list.add(index);
            }
            if(list.isEmpty()) list.add(-1);
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
