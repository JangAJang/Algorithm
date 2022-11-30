import java.util.*;

class Solution {

    private final Queue<Integer> daysToFinish = new ArrayDeque<>();

    public int[] solution(int[] progresses, int[] speeds) {
        calculateAllDaysToFinish(progresses, speeds);
        return getCounts();
    }

    private int[] getCounts(){
        List<Integer> counts = new ArrayList<>();
        while(!daysToFinish.isEmpty()){
            counts.add(makeCountForOnce());
        }
        return counts.stream().mapToInt(Integer::intValue).toArray();
    }

    private int makeCountForOnce(){
        if(daysToFinish.isEmpty()) return 0;
        int lastOne = daysToFinish.poll();
        int count = 1;
        while(daysToFinish.peek() != null &&lastOne >= daysToFinish.peek()){
            count++;
            daysToFinish.poll();
        }
        return count;
    }

    private void calculateAllDaysToFinish(int[] progresses, int[] speeds){
        for(int index = 0; index < progresses.length; index++){
            daysToFinish.add(calculateDaysToFinish(progresses[index], speeds[index]));
        }
    }

    private int calculateDaysToFinish(int progress, int speed){
        if( (100 - progress) % speed == 0) return (100 - progress) / speed;
        return (100 - progress) / speed + 1;
    }
}