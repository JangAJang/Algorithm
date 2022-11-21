import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long left, long right) {
        return getSplit(n, left, right);
    }

    private int[] getSplit(int n, long left, long right){
        List<Integer> numbers = new ArrayList<>();
        for(long start = left; start <= right; start++){
            numbers.add((int)(Math.max(start/n, start%n)+1));
        }
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}