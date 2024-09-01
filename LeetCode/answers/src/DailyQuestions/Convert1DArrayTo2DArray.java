package DailyQuestions;

public class Convert1DArrayTo2DArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length) {
            return new int[0][0];
        }

        int[][] answer = new int[m][n];

        for(int index = 0; index < original.length; index++) {
            answer[index / n][index % n] = original[index];
        }

        return answer;
    }
}
