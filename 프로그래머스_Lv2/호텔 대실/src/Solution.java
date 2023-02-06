import java.util.Arrays;
import java.util.OptionalInt;

class Solution {

    private static final int TOTAL_TIME = 1450;
    private static final int CLEANING_TIME = 10;

    public int solution(String[][] book_time) {
        int[] count = new int[TOTAL_TIME];
        for (String[] strings : book_time) {
            int start = getTime(strings[0]);
            int end = getTime(strings[1]) + CLEANING_TIME;
            count[start]++;
            count[end]--;
        }
        int result = 0;
        for(int index = 1; index < TOTAL_TIME; index++){
            count[index] += count[index-1];
            result = Math.max(count[index], result);
        }
        return result;
    }

    private int getTime(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

}