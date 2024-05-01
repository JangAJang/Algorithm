package DailyQuestions;

public class ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {
        int reverseIndex = findReverseIndex(word, ch);
        if(reverseIndex == word.length()) return word;
        String prefix = word.substring(0, reverseIndex+1);
        String suffix = word.substring(reverseIndex+1);
        return reversePrefix(prefix) + suffix;
    }

    private String reversePrefix(String prefix) {
        StringBuilder sb = new StringBuilder();
        for(int index = prefix.length()-1; index >=0; index--) {
            sb.append(prefix.charAt(index));
        }
        return sb.toString();
    }

    private int findReverseIndex(String word, char ch) {
        for(int index = 0; index < word.length(); index++) {
            if(word.charAt(index) == ch) return index;
        }
        return word.length();
    }
}
