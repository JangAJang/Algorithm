package DailyQuestions;

import java.util.*;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int count = 0;

        for(int index = 0; index < heights.length; index++) {
            if(heights[index] != copy[index]) count++;
        }

        return count;
    }
}
