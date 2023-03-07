import java.util.Stack;

class Solution {

    private Stack<Character> stack = new Stack<>();

    public int solution(String s) {
        putAlphabets(s);
        return getAbilityToDeleteAll();
    }

    private int getAbilityToDeleteAll(){
        if(stack.isEmpty()) return 1;
        return 0;
    }

    private void putAlphabets(String s){
        for(int stringIndex = 0; stringIndex < s.length(); stringIndex++){
            deletePairOrPush(s.charAt(stringIndex));
        }
    }

    private boolean isPair(char newCharacter){
        return !stack.isEmpty() && stack.peek() == newCharacter;
    }

    private void deletePair(){
        stack.pop();
    }

    private void deletePairOrPush(char newCharacter){
        if(isPair(newCharacter)){
            deletePair();
            return;
        }
        if(isAbleToPush(newCharacter)) pushAlphabet(newCharacter);
    }

    private void pushAlphabet(char newCharacter){
        stack.push(newCharacter);
    }

    private boolean isAbleToPush(char newCharacter){
        return stack.isEmpty() || stack.peek() != newCharacter;
    }
}