class Solution {
    public int solution(int[] arr) {
        return getLCMOfMultipleNumber(arr);
    }

    private int getLCMOfMultipleNumber(int[] arr){
        int result = arr[0];
        for(int index = 1; index < arr.length; index++){
            result = getLCM(result, arr[index]);
        }
        return result;
    }

    private int getLCM(int a, int b){
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        int r = a - (a / b) * b;
        if (r != 0) return gcd(b, r);
        return b;
    }
}