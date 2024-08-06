package DailyQuestions;

public class MinimumNumberOfPushesToTypeWordII {

    private static final int MAX_COUNT = 8;

    public int minimumPushes(String word) {
        int count = 0;
        int point = 1;
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for(String each : word.split("")) {
            map.put(each, map.getOrDefault(each, 0)+1);
        }

        for(String each : map.keySet().stream()
            .sorted(Comparator.comparingInt(each -> -1 * map.get(each)))
            .toList()) {
            answer += point * map.get(each);

            count++;
            if(count == MAX_COUNT) {
                count = 0;
                point++;
            }
        }

        return answer;
    }
}
