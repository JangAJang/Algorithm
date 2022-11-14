class Solution {

    private int round = 0;

    public int solution(int n, int a, int b) {
        return getRoundToMatchWithRival(a, b);
    }

    private int getRoundToMatchWithRival(int a, int b){
        if(a == b) return round;
        round++;
        if(a % 2 != 0) a +=1;
        if(b%2 != 0) b += 1;
        return getRoundToMatchWithRival(a/2, b/2);
    }
}