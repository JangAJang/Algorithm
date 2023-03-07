import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] counts = new int[10_000_001];
        for(int index = 0; index < tangerine.length; index++){
            counts[tangerine[index]]++;
        }
        Arrays.sort(counts);
        int count = 0;
        for(int index = counts.length-1; index >=0; index--){
            count += counts[index];
            if(k <= count) return counts.length - index;
        }
        return -1;
    }
}