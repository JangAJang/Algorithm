import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        List<SubSequence> subs = new ArrayList<>();
        while (true){
            if(sum == k){
                subs.add(new SubSequence(left, right));
            }
            if(left == sequence.length && right == sequence.length) break;
            if(sum <= k && right < sequence.length){
                right++;
                if(right < sequence.length) {
                    sum += sequence[right];
                }
                continue;
            }
            if(left < sequence.length) sum -= sequence[left];
            left++;
        }
        subs.sort(SubSequence::compareTo);
        return new int[]{subs.get(0).left, subs.get(0).right};
    }

    private static class SubSequence implements Comparable<SubSequence>{
         private final int left, right, size;

        public SubSequence(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = right - left;
        }

        @Override
        public int compareTo(SubSequence o) {
            if(this.size == o.size){
                return this.left - o.left;
            }
            return this.size - o.size;
        }
    }
}