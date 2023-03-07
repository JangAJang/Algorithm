import java.util.*;
import java.util.stream.Collectors;

class Solution {

    Queue<Integer> scoreSorted;

    public int solution(int k, int m, int[] score) {
        sortScores(score);
        return getMaximumPrice(m);
    }

    private void sortScores(int[] score){
        scoreSorted = Arrays.stream(score).boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private int getMaximumPrice(int m){
        int result = 0;
        while(scoreSorted.size() >= m){
            result += makeBox(m);
        }
        return result;
    }

    private int makeBox(int m){
        int min = Integer.MAX_VALUE;
        for(int index = 0; index < m; index++){
            min = Math.min(scoreSorted.poll(), min);
        }
        return min*m;
    }
}