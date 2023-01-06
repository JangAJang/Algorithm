import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        List<Integer> allSorted = Arrays.stream(numbers).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return -Integer.parseInt(Integer.toString(integer) + Integer.toString(t1))
                        + Integer.parseInt(Integer.toString(t1) + Integer.toString(integer));
            }
        }).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        allSorted.forEach(sb::append);
        if(sb.toString().charAt(0) == '0') return "0";
        return sb.toString();
    }
}