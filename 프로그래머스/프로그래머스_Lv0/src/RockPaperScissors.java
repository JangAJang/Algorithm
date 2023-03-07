import java.util.Arrays;

public class RockPaperScissors {
    //lv0. 가위 바위 보
    class Solution {

        private static final String ROCK = "0";
        private static final String SCISSORS = "2";
        private static final String PAPER = "5";

        public String solution(String rsp) {
            StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(rsp.split("")).forEach(s-> stringBuilder.append(getWinning(s)));
            return stringBuilder.toString();
        }

        private String getWinning(String rsp){
            if(rsp.equals(ROCK)) return PAPER;
            if(rsp.equals(SCISSORS)) return ROCK;
            return SCISSORS;
        }
    }
}
