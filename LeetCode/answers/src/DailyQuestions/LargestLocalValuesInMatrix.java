package DailyQuestions;

public class LargestLocalValuesInMatrix {

    public int[][] largestLocal(int[][] grid) {
        int[][] answer = new int[grid.length-2][grid[0].length-2];
        for(int x = 0; x < answer.length; x++) {
            for(int y = 0; y < answer[0].length; y++) {
                int value = 0;
                for(int xMove = 0; xMove < 3; xMove++) {
                    for(int yMove = 0; yMove < 3; yMove++) {
                        int xNext = x + xMove;
                        int yNext = y + yMove;
                        value = Math.max(value, grid[xNext][yNext]);
                    }
                }
                answer[x][y] = value;
            }
        }
        return answer;
    }
}
