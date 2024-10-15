package DailyQuestions;

public class SeperateBlackAndWhiteBalls {

    public long minimumSteps(String s) {
        long answer = 0;
        long count = 0;
        if(s.charAt(s.length()-1) == '1') count++;

        for(int index = s.length() - 2; index >= 0; index--) {
            if(s.charAt(index) == '1') {
                answer += (s.length()-1) - count - index;
                count++;
            }
        }

        return answer;
    }
}
