package DailyQuestions;

public class ScoreOfString {

    public int scoreOfString(String s) {
        int answer = 0;
        for(int index = 0; index < s.length()-1; index++) {
            answer += Math.abs(s.charAt(index) - s.charAt(index+1));
        }
        return answer;
    }
}
