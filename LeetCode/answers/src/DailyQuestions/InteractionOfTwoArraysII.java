package DailyQuestions;

public class InteractionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = countNumbers(nums1);
        Map<Integer, Integer> map2 = countNumbers(nums2);

        List<Integer> list = new ArrayList<>();

        for(int each : map1.keySet()) {
            if(map2.getOrDefault(each, 0) == 0) {
                continue;
            }

            for(int index = 0; index < Math.min(map1.get(each), map2.get(each)); index++) {
                list.add(each);
            }
        }

        int[] arr = new int[list.size()];

        for(int index = 0; index < arr.length; index++) {
            arr[index] = list.get(index);
        }

        return arr;
    }

    private Map<Integer, Integer> countNumbers(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int each : arr) {
            map.put(each, map.getOrDefault(each, 0) + 1);
        }

        return map;
    }
}
