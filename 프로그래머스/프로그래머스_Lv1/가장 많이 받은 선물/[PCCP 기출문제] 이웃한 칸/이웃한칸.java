class Solution {
    
    private static final int[][] arr = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int solution(String[][] board, int h, int w) {
        String target = board[h][w];
        
        int count = 0;
        
        for(int[] each : arr) {
            int newH = h + each[0];
            int newW = w + each[1];
            
            if(newH < 0 || newH >= board.length || newW < 0 || newW >= board[0].length) continue;
            if(target.equals(board[newH][newW])) count++;
        }
        
        return count;
    }
}