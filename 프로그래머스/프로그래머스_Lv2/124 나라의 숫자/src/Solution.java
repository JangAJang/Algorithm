class Solution {

    private final StringBuilder madeNumber = new StringBuilder();

    public String solution(int n) {
        makeNumber(n);
        return madeNumber.toString();
    }

    private void makeNumber(int n){
        if(n == 1) {
            madeNumber.append("1");
            return;
        }
        if(n == 2) {
            madeNumber.append("2");
            return;
        }
        if(n == 3 || n == 0) {
            madeNumber.append("4");
            return;
        }
        makeNumber((n-1)/3);
        makeNumber(n%3);
    }
}