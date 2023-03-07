class Solution {

    private int ZERO = 0;
    private int ONE = 0;

    private int[][] oneAndZero;

    public int[] solution(int[][] arr) {
        oneAndZero = arr;
        countOneAndZero(0, 0, oneAndZero.length);
        return new int[]{ZERO, ONE};
    }

    private void countOneAndZero(int x, int y, int length){
        if(isAllSame(x, y, length)){
            if(oneAndZero[x][y] == 0) {
                ZERO++;
                return;
            }
            ONE++;
            return;
        }
        countOneAndZero(x, y, length/2);
        countOneAndZero(x+length/2, y, length/2);
        countOneAndZero(x, y+length/2, length/2);
        countOneAndZero(x+length/2, y+length/2, length/2);

    }

    private boolean isAllSame(int x, int y, int length){
        int starter = oneAndZero[x][y];
        for(int index = x; index < x + length; index++){
            for(int indexY = y; indexY < y+length; indexY++){
                if(starter != oneAndZero[index][indexY]){
                    return false;
                }
            }
        }
        return true;
    }
}