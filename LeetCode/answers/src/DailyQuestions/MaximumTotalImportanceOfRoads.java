package DailyQuestions;

public class MaximumTotalImportanceOfRoads {

    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] road : roads) {
            map.put(road[0], map.getOrDefault(road[0], 0)+1);
            map.put(road[1], map.getOrDefault(road[1], 0)+1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Comparator.comparingInt(each -> map.get(each)));

        Map<Integer, Integer> score = new HashMap<>();

        for(int index = list.size()-1; index >=0; index--) {
            score.put(list.get(index), n);
            n--;
        }

        int answer = 0;

        for(int key : map.keySet()) {
            System.out.println(key + ":" + map.get(key) + ", " + score.get(key));
            answer += map.get(key) * score.get(key);
        }

        return answer;
    }
}
