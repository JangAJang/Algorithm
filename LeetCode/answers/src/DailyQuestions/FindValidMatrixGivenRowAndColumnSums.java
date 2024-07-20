package DailyQuestions;

public class FindValidMatrixGivenRowAndColumnSums {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];

        // 행렬을 채우기 위한 알고리즘
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                int value = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = value;
                rowSum[i] -= value;
                colSum[j] -= value;
            }
        }

        return matrix;
    }
}
