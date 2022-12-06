import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int k, int[] score) {
        return getHoFs(k, score);
    }

    private int[] getHoFs(int k, int[] score){
        int[] hoF = new int[score.length];
        for(int index = 0; index < score.length; index++){
            hoF[index] = getKOfHoF(k, Arrays.copyOfRange(score, 0, index+1));
        }
        return hoF;
    }

    private int getKOfHoF(int k, int[] arr){
        if(arr.length < k) return Arrays.stream(arr).boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()).get(arr.length-1);
        return Arrays.stream(arr).boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()).get(k-1);
    }
}