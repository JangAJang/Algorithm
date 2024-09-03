package DailyQuestions;

public class SumOfDigitOfStringAfterConvert {

    public int getLucky(String s, int k) {
        String value = "";
        for(char each : s.toCharArray()) {
            value += convertAlphabetToString(each);
        }

        while(k-- > 0) {
            value = convertToSum(value);
        }

        return Integer.parseInt(value);
    }

    private String convertAlphabetToString(final char alphabet) {
        return Integer.toString(alphabet - 'a' + 1);
    }

    private String convertToSum(final String value) {
        int answer = 0;

        for(String each : value.split("")) {
            answer += Integer.parseInt(each);
        }

        return Integer.toString(answer);
    }
}
