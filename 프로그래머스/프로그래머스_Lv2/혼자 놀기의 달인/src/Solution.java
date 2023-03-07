import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private boolean[] visited;
    public int solution(int[] cards) {
        visited  = new boolean[cards.length];
        List<Integer> boxes = new ArrayList<>();
        while(getStartingIndex()!= -1 || !isAllVisited()){
            boxes.add(countOneSet(cards, getStartingIndex()));
        }
        if(boxes.size() <= 1) return 0;
        boxes.sort(Collections.reverseOrder());
        return boxes.get(0) * boxes.get(1);
    }

    private boolean isAllVisited(){
        for(boolean visit : visited){
            if(!visit) return false;
        }
        return true;
    }

    private int countOneSet(int[] cards, int index){
        int currentCard = index;
        int count = 0;
        while(!visited[currentCard]){
            visited[currentCard] = true;
            count++;
            currentCard = cards[currentCard]-1;
        }
        return count;

    }

    private int getStartingIndex(){
        for(int index = 0; index < visited.length; index++){
            if(!visited[index]) return index;
        }
        return -1;
    }
}