import java.util.*;

public class KolatzArray {
    class Solution {
        public int[] solution(int n) {
            List<Integer> list = new ArrayList<>();
            list.add(n);
            while(n != 1) {
                if(n % 2 == 0) {
                    list.add(n/2);
                    n /= 2;
                    continue;
                }
                list.add( 3* n +1);
                n = 3*n+1;
                continue;
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
