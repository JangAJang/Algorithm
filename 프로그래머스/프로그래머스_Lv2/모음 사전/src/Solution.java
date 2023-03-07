import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int[] CASES = new int[]{781, 156, 31, 6, 1};

    public int solution(String word) {
        List<Character> vowels = makeVowels();
        int result = 0;
        for(int index = 0; index < word.length(); index++){
            result += vowels.indexOf(word.charAt(index)) * CASES[index];
        }
        return result+word.length();
    }

    private List<Character> makeVowels(){
        List<Character> vowels = new ArrayList<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        return vowels;
    }
}