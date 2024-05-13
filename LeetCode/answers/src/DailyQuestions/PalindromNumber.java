package DailyQuestions;

public class PalindromNumber {

    public boolean isPalindrome(int x) {
        String X = Integer.toString(x);
        for(int index = 0; index < X.length()/2+1; index++) {
            if(X.charAt(index) != X.charAt(X.length() - 1 - index)) return false;
        }
        return true;
    }
}
