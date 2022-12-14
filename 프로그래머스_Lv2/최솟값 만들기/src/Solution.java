import java.util.Arrays;

class Solution
{
    public int solution(int[] A, int [] B) {
        return getMinimumMultiSum(A, B);
    }

    private int getMinimumMultiSum(int[] A, int[] B){
        sortArrays(A, B);
        return addMultiplies(A, B);
    }

    private void sortArrays(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
    }

    private int addMultiplies(int[] A, int[] B){
        int result = 0;
        int total_index = A.length-1;
        for(int index = 0; index< A.length; index++){
            result += A[index] * B[total_index - index];
        }
        return result;
    }
}