import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(works).forEach(each -> pq.add(each));
        for(int index = 0; index < n; index++) {
            int value = pq.poll();
            if(value == 0) return 0;
            pq.add(value-1);
        }

        long answer = 0;
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}