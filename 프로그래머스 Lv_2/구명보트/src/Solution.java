import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    private final Deque<Integer> peopleSorted = new ArrayDeque<>();
    private int boatCount = 0;

    public int solution(int[] people, int limit) {
        setPeopleSorted(people);
        getPeopleCount(limit);
        return boatCount;
    }

    private void setPeopleSorted(int[] people){
        Arrays.sort(people);
        for(int number : people){
            peopleSorted.add(number);
        }
    }

    private void getPeopleCount(int limit){
        while(!peopleSorted.isEmpty()){
            countBoatAble(limit);
        }
    }

    private void countBoatAble(int limit){
        if(isOneLeft()) {
            countLast();
            return;
        }
        if(pairBiggerThanLimit(limit)) {
            countOneWithLast();
            return;
        }
        countOneWithTwo();
    }

    private boolean isOneLeft(){
        return peopleSorted.size() == 1;
    }

    private void countLast(){
        peopleSorted.pop();
        boatCount++;
    }

    private boolean pairBiggerThanLimit(int limit){
        return peopleSorted.getFirst() + peopleSorted.getLast() > limit;
    }

    private void countOneWithLast(){
        peopleSorted.pollLast();
        boatCount++;
    }

    private void countOneWithTwo(){
        peopleSorted.pollLast();
        peopleSorted.pollFirst();
        boatCount++;
    }
}