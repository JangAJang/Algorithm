class Solution {

    private static final int DIVIDER = 1_000_000_007;

    public int solution(int n) {
        int[] answer = new int[n+1];
        answer[0] = 0;
        answer[1] = 1;
        answer[2] = 2;
        answer[3] = 3;
        for(int index = 4; index <= n; index++){
            answer[index] = (answer[index-1] + answer[index-2]) % DIVIDER;
        }
        return answer[n];
    }
}