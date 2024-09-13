package DailyQuestions;

public class XORQueriesForSubarray {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] subarray = getSubArray(arr);
        int[] answer = new int[queries.length];
        for(int index = 0; index < queries.length; index++) {
            answer[index] = subarray[queries[index][0]] ^ subarray[queries[index][1]] ^ arr[queries[index][0]];
        }

        return answer;
    }

    private int[] getSubArray(final int[] arr) {
        int[] sub = new int[arr.length];
        sub[0] = arr[0];
        for(int index = 1; index < arr.length; index++) {
            sub[index] = arr[index] ^ sub[index-1];
        }

        return sub;
    }
}
