package DailyQuestions;

import java.util.*;

public class FindTheLengthOfLongestCommonPrefix {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set1 = createSet(arr1);
        Set<String> set2 = createSet(arr2);

        final Map<String, Integer> map = new HashMap<>();
        int max = addToMap(map, set1);
        max = addToMap(map, set2);

        return max;
    }

    private int addToMap(final Map<String, Integer> map, final Set<String> set) {
        int max = 0;
        for(String each : set) {
            if(!map.containsKey(each)) {
                map.put(each, 1);
                continue;
            }

            if(max < each.length()) {
                max = each.length();
            }
        }
        return max;
    }

    private Set<String> createSet(final int[] arr1) {
        final Set<String> set = new HashSet<>();
        for(int each : arr1) {
            String value = Integer.toString(each);

            for(int index = 1; index <= value.length(); index++) {
                set.add(value.substring(0, index));
            }
        }

        return set;
    }
}
