class Solution {

    private static final long DIVIDER  =1_000_000_007;

    public int solution(int n) {
        long[] array = new long[n+1];
        array[2] = 3;
        array[4] = 11;
        for(int index = 6; index <= n; index +=2){
            array[index] = (((4 * array[index-2]) % DIVIDER - array[index-4]%DIVIDER)+DIVIDER) % DIVIDER;
        }
        return (int)array[n];
    }
}