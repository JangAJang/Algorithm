import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> queue1 = Arrays.stream(cards1).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> queue2 = Arrays.stream(cards2).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> target = Arrays.stream(goal).collect(Collectors.toCollection(ArrayDeque::new));
        while(!target.isEmpty()){
            if(!queue1.isEmpty() && queue1.getFirst().equals(target.getFirst())){
                queue1.pollFirst();
                target.pollFirst();
                continue;
            }
            if(!queue2.isEmpty() && queue2.getFirst().equals(target.getFirst())){
                queue2.pollFirst();
                target.pollFirst();
                continue;
            }
            return "No";
        }
        return "Yes";
    }
}