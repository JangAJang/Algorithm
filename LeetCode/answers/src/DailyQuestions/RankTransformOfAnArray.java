package DailyQuestions;

public class RankTransformOfAnArray {

    public int[] arrayRankTransform(int[] arr) {
        final int[] answer = arr.clone();
        Arrays.sort(arr);
        final Map<Integer, Integer> map = new HashMap<>();
        for(int each : arr) {
            if(map.containsKey(each)) continue;
            map.put(each, map.keySet().size()+1);
        }

        for(int index = 0; index < arr.length; index++) {
            answer[index] = map.get(answer[index]);
        }

        return answer;
    }
}
