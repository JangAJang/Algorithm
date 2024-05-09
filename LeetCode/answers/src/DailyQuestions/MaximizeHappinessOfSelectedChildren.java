package DailyQuestions;

public class MaximizeHappinessOfSelectedChildren {

    public long maximumHappinessSum(int[] happiness, int k) {
        long answer = 0L;
        int length = happiness.length;
        Arrays.sort(happiness);
        for(int index = 1; index <=k; index++) {
            answer += Math.max(0, happiness[length-index] - (index-1));
        }
        return answer;
    }
}
