import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[col-1] == t1[col-1]){
                    return (t1[0] - ints[0]);
                }
                return ints[col-1] - t1[col-1];
            }
        });
        int result = 0;
        for(int index = row_begin; index <= row_end; index++){
            int nextValue = getS_i(data[index-1], index);
            result = result^nextValue;
        }
        return result;
    }

    private int getS_i(int[] row, int index){
        int result = 0;
        for(int data : row){
            result += data%index;
        }
        return result;
    }
}