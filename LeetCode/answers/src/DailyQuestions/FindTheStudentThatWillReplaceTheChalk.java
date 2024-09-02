package DailyQuestions;

public class FindTheStudentThatWillReplaceTheChalk {

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;

        for(int each : chalk) {
            sum += each;
        }

        long left = k - sum * (k / sum);

        for(int index = 0; index < chalk.length; index++) {
            if(left < chalk[index]) {
                return index;
            }

            left -= chalk[index];
        }

        return 0;
    }
}
