public class MakeRectangle {
    class Solution {
        public int[][] solution(int[][] arr) {
            int size = Math.max(arr.length, arr[0].length);
            int[][] answer = new int[size][size];
            for(int x = 0; x < arr.length; x++) {
                System.arraycopy(arr[x], 0, answer[x], 0, arr[0].length);
            }
            return answer;
        }
    }
}
