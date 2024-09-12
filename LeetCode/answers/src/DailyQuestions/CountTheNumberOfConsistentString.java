package DailyQuestions;

public class CountTheNumberOfConsistentString {

    public int countConsistentStrings(String allowed, String[] words) {
        Map<Character, Boolean> map = new HashMap<>();
        for(char each : allowed.toCharArray()) {
            map.put(each, false);
        }

        int answer = 0;
        for(String word : words) {
            for(char each : word.toCharArray()) {
                if(map.getOrDefault(each, true)) {
                    answer++;
                    break;
                }
            }
        }

        return words.length - answer;
    }
}
