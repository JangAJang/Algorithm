package DailyQuestions;

public class NumberComplement {

    public int findComplement(int num) {
        final String parsed = Integer.toBinaryString(num);
        String answer = "";
        for(String each : parsed.split("")) {
            if(each.equals("1")) {
                answer += "0";
                continue;
            }

            answer += "1";
        }

        return Integer.parseInt(answer, 2);
    }
}
