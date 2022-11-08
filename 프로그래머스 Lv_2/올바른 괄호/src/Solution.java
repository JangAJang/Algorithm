import java.util.Stack;

class Solution {

    Stack<Character> parenthesisStack = new Stack<>();

    boolean solution(String s) {
        return checkParenthesis(s);
    }

    private boolean checkParenthesis(String s){
        for(int index = 0; index < s.length(); index++){
            if(s.charAt(index) == ')' && parenthesisStack.isEmpty()) return false;
            if(!parenthesisStack.isEmpty() && parenthesisStack.peek() == '(' && s.charAt(index) == ')'){
                parenthesisStack.pop();
                continue;
            }
            parenthesisStack.push(s.charAt(index));
        }
        return parenthesisStack.isEmpty();
    }
}