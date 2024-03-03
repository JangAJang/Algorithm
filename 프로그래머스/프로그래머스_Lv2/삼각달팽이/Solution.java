class Solution {
    public int[] solution(int n) {
        int[][] numArr = new int[n+1][n+1];
        int row = -1,
            col = 0;
        int curNum = 1;
        int[] answer = new int[ n * (n-1) / 2 + 1];

        for (int i = n; i > 0; i -= 3) {
            for (int j = 0; j < i; j++) {
            numArr[++row][col] = curNum++;
            }
            for (int j = 0; j < i - 1; j++) {
            numArr[row][++col] = curNum++;
            }
            for (int j = 0; j < i - 2; j++) {
            numArr[--row][--col] = curNum++;
            }
        }

        for(int x = 1; x <=n; x++) {
            for(int y = 1; y <=n; y++) {
                int index = (x-1)*n + (y-1);
                answer[index] = numArr[x][y];
            }
        }
        return answer;
    }
}