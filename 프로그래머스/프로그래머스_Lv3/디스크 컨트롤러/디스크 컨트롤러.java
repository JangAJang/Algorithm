import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {


    private int answer = 0;
    private int time = 0;
    private PriorityQueue<int[]> workQue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    private PriorityQueue<int[]> inQue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

    public int solution(int[][] jobs) {
        for(int[] j : jobs) inQue.offer(j);
        while(hasWorksToDo()){
            while(canWorkNow()) workQue.offer(inQue.poll());
            setTime();
        }
        answer /= jobs.length;
        return answer;
    }
    
    private boolean canWorkNow() {
        return !inQue.isEmpty() && inQue.peek()[0] <= time;
    }

    private boolean hasWorksToDo() {
        return !inQue.isEmpty() || !workQue.isEmpty();
    }

    private void setTime() {
        if(workQue.isEmpty()){ 
            time = inQue.peek()[0];
            return;
        }
        
        int[] j = workQue.poll();
        answer += time + j[1] - j[0];
        time += j[1];
    }
}