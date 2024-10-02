package DailyQuestions;

public class RankTransformOfAnArray {

    public int[] arrayRankTransform(int[] arr) {
        final Set<Integer> set = new HashSet<>();
        for(int each : arr) {
            set.add(each);
        }

        final List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int index = 0; index < arr.length; index++) {
            arr[index] = getRankOf(arr[index], list);
        }

        return arr;
    }

    private int getRankOf(final int value, final List<Integer> list) {
        for(int index = 0; index < list.size(); index++) {
            if(value == list.get(index)) return index+1;
        }

        return -1;
    }
}
