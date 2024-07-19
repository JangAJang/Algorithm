package DailyQuestions;

public class LuckyNumberInMatrix {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int[] rowMin = new int[matrix.length];
        int[] colMax = new int[matrix[0].length];

        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);

        List<Integer> rows = new ArrayList<>();

        for(int x = 0; x < matrix.length; x++) {
            for(int y = 0; y < matrix[0].length; y++) {
                final int val = matrix[x][y];
                rowMin[x] = Math.min(rowMin[x], val);
                colMax[y] = Math.max(colMax[y], val);
            }

            rows.add(rowMin[x]);
        }

        for(int each : colMax) {
            if(rows.contains(each)) {
                answer.add(each);
            }
        }

        return answer;
    }
}
