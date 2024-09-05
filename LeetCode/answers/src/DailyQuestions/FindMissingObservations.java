package DailyQuestions;

public class FindMissingObservations {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] answer = new int[n];
        int sum = 0;

        for(int each : rolls) {
            sum += each;
        }

        sum = mean * (rolls.length + n) - sum;
        if(sum < n) return new int[0];
        if((double)sum / (double)(n) > 6) return new int[0];

        Arrays.fill(answer, sum / n);
        int left = sum % n;

        int index = 0;
        while(left > 0) {
            final int adder = Math.min(6 - answer[index], left);
            answer[index] += adder;
            left -= adder;
            index++;
        }
        return answer;
    }
}
