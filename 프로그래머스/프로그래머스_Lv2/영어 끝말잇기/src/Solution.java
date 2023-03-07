import java.util.Stack;

class Solution {

    private final Stack<String> spokenWords = new Stack<>();

    public int[] solution(int n, String[] words) {
        return getLocationOfEnd(n, words);
    }

    private int[] getLocationOfEnd(int n, String[] words){
        for(String word : words){
            if(isUnableToPut(word)) return makeResult(n);
            spokenWords.push(word);
        }
        return new int[]{0, 0};
    }

    private int[] makeResult(int n){
        return new int[]{spokenWords.size() % n + 1 , spokenWords.size() / n + 1};
    }

    private boolean isNotEmpty(){
        return !spokenWords.isEmpty();
    }

    private boolean isUnableToPut(String word){
        return isNotEmpty() && (isAlreadySpoken(word) || isNotRightNextWord(word));
    }

    private boolean isAlreadySpoken(String word){
        return spokenWords.contains(word);
    }

    private boolean isNotRightNextWord(String word){
        return getLastAlphabet(spokenWords.peek()) != getFirstAlphabet(word);
    }

    private char getFirstAlphabet(String word){
        return word.charAt(0);
    }

    private char getLastAlphabet(String word){
        return word.charAt(word.length()-1);
    }
}