package DailyQuestions;

public class MinimumTimeDifferences {

    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for(String each : timePoints) {
            String[] split = each.split(":");
            int time = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            list.add(time);
        }

        Collections.sort(list);
        list.add(list.get(0) + 1440);
        int min = Integer.MAX_VALUE;
        for(int index = 0; index < timePoints.size(); index++) {
            min = Math.min(min, list.get(index+1) - list.get(index));
        }

        return min;
    }
}
