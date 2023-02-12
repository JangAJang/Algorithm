import java.util.Arrays;

class Solution
{
    public int solution(int [][]board) {
        if(board.length == 1 || board[0].length == 1) {
            for (int[] ints : board) {
                for (int anInt : ints) {
                    if (anInt == 1) return 1;
                }
            }
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int[] ints : board) {
            if (Arrays.stream(ints).sum() > 0) {
                result = 1;
                break;
            }
        }
        for(int x = 1; x < board.length; x++){
            for(int y = 1; y < board[0].length; y++){
                if(board[x][y] != 0 && board[x-1][y] != 0 && board[x][y-1] != 0 && board[x-1][y-1] != 0){
                    int formerSize = Math.min(Math.min(board[x-1][y], board[x][y-1]), board[x-1][y-1]);
                    board[x][y] = formerSize+1;
                    result = Math.max(board[x][y], result);
                }
            }
        }
        return result*result;
    }
}