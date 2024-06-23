package DailyQuestions;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxq = new ArrayDeque<>();
        Deque<Integer> minq = new ArrayDeque<>();
        int n = nums.length;
        int j = 0;
        int ans = 0;
        for(int i = 0; i < n; i ++){
            while(!maxq.isEmpty() && nums[i] > maxq.peekLast())
                maxq.pollLast();
            maxq.addLast(nums[i]);
            while(!minq.isEmpty() && nums[i] < minq.peekLast()){
                minq.pollLast();
            }
            minq.addLast(nums[i]);
            if(maxq.peekFirst() - minq.peekFirst() > limit){
                if(nums[j] == maxq.peekFirst()) maxq.pollFirst();
                if(nums[j] == minq.peekFirst()) minq.pollFirst();
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
