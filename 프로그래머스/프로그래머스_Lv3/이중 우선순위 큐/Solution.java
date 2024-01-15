import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> bigPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> smallPQ = new PriorityQueue<>();
        for(int index = 0; index < operations.length; index++) {
            String[] split = operations[index].split(" ");
            int num = Integer.parseInt(split[1]);
            switch(split[0]) {
                case "I":
                    smallPQ.add(num);
                    bigPQ.add(num);
                    break;
                case "D":
                    if(bigPQ.isEmpty()) break;
                    if(num == 1) {
                        int del = bigPQ.poll();
                        smallPQ.remove(del);
                    }
                    if(num == -1) {
                        int del = smallPQ.poll();
                        bigPQ.remove(del);
                    }
            }
        }
        if(bigPQ.isEmpty())
            return new int[] {0, 0};
        int[] answer = new int[2];
        answer[0] = bigPQ.poll();
        answer[1] = smallPQ.poll();
        return answer;
    }
}