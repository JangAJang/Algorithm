package DailyQuestions;

public class KthDistinctStringInAnArray {

    public String kthDistinct(String[] arr, int k) {
        final Map<String, Integer> map = new HashMap<>();

        for(String each : arr) {
            map.put(each, map.getOrDefault(each, 0)+1);
        }

        int count = 0;

        for(String each : arr) {
            if(map.get(each) == 1) count++;
            if(count == k) return each;
        }

        return "";
    }
}
