package DailyQuestions;

import java.util.*;

public class SortColors {

    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int each : nums) {
            map.put(each, map.getOrDefault(each, 0)+1);
        }

        int index = 0;

        for(int key = 0; key < 3; key++) {
            if(!map.containsKey(key)) continue;
            int value = map.get(key);
            while(value-- > 0) {
                nums[index] = key;
                index++;
            }
        }
    }
}
