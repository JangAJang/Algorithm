package DailyQuestions;

import java.util.*;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] answer = new int[arr1.length];

        for(int each : arr1) {
            map.put(each, map.getOrDefault(each, 0)+1);
        }

        int index = 0;

        for(int each : arr2) {
            int value = map.get(each);
            while(value > 0) {
                answer[index] = each;
                value--;
                index++;
            }

            map.remove(each);
        }

        for(int each : map.keySet().stream().sorted().toList()) {
            int value = map.get(each);
            while(value > 0) {
                answer[index] = each;
                value--;
                index++;
            }

            map.remove(each);
        }

        return answer;
    }
}
