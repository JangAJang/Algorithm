package DailyQuestions;
import java.util.*;
public class OpenTheLock {
    class Solution {
        public int openLock(String[] deadends, String target) {
            Map<String, Boolean> visited = new HashMap<>();
            Map<String, Integer> answer = new HashMap<>();

            for(String deadline: deadends) {
                visited.put(deadline, true);
            }

            Queue<String> queue = new ArrayDeque<>();
            queue.add("0000");
            answer.put("0000", 0);
            while(!queue.isEmpty()) {
                String current = queue.poll();
                if(visited.getOrDefault(current, false)) continue;
                visited.put(current, true);
                for(int index = 0; index < 4; index++) {
                    int formerValue = Integer.parseInt(current.substring(index, index+1));
                    int clockwise = (formerValue + 1)%10;
                    int counterclock = (formerValue + 9) % 10;
                    String clock = flipAtIndex(current, clockwise, index);
                    queue.add(clock);
                    if(!answer.containsKey(clock)) answer.put(clock, answer.get(current)+1);
                    String counter = flipAtIndex(current, counterclock, index);
                    queue.add(counter);
                    if(!answer.containsKey(counter)) answer.put(counter, answer.get(current)+1);
                }
            }
            return answer.getOrDefault(target, -1);
        }

        private String flipAtIndex(String former, int adder, int index) {
            String prefix = former.substring(0, index);
            String suffix = former.substring(index+1, former.length());
            return prefix + adder + suffix;
        }
    }
}
