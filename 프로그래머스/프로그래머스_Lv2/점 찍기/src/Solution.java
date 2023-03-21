class Solution {
    public long solution(int k, int d) {
        long count = 0;
        for(int x = 0; x <= d; x +=k){
            double result = (Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2)));
            count+= Math.ceil(result / k) + (result % k == 0 ? 1 : 0);
        }
        return count;
    }
}