class Solution {

    private int[][] resultRadix;

    public int[][] solution(int[][] arr1, int[][] arr2) {
        resultRadix = new int[arr1.length][arr2[0].length];
        multiplyRadix(arr1, arr2);
        return resultRadix;
    }

    private void multiplyRadix(int[][] arr1, int[][] arr2){
        for(int indexX = 0; indexX < resultRadix.length; indexX++){
            for(int indexY = 0; indexY < resultRadix[0].length; indexY++){
                for(int a = 0; a < arr1[0].length; a++){
                    resultRadix[indexX][indexY] += arr1[indexX][a] * arr2[a][indexY];
                }
            }
        }
    }
}