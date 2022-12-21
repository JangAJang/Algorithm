import java.util.List;
import java.util.PriorityQueue;

class Solution {

    private final PriorityQueue<Integer> scovilleSort = new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        sortScoville(scoville);
        return getCountUntilK(K);
    }

    private int getCountUntilK(int K){
        int count = 0;
        while(scovilleSort.stream().anyMatch(s-> s< K)){
            if(scovilleSort.size() == 1) return -1;
            makeNewFood();
            count++;
        }
        return count;
    }

    private void sortScoville(int[] scoville){
        for(int valueEach : scoville){
            scovilleSort.add(valueEach);
        }
    }

    private void makeNewFood(){
        scovilleSort.add(scovilleSort.poll() + scovilleSort.poll()*2);
    }
}