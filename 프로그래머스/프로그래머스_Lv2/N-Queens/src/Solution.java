class Solution {
    private int count = 0;
    private int[] queen;
    public int solution(int n) {
        queen = new int[n];
        checkQueens(0, n);
        return count;
    }

    private void checkQueens(int index, int n){
        if(index == n){
            count++;
            return;
        }
        for(int i = 0; i < n; i++){
            queen[index] = i;
            if(isQueenHereValid(index)) checkQueens(index+1, n);
        }
    }

    private boolean isQueenHereValid(int index){
        for (int j = 0; j < index; j++) {
            if (queen[index] == queen[j]) return false;
            if (Math.abs(index - j) == Math.abs(queen[index] - queen[j])) return false;
        }
        return true;
    }
}