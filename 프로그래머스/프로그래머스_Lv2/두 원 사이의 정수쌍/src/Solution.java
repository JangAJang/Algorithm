class Solution {
    public long solution(int r1, int r2) {
        long count = 0;
        for(int x = 0; x <= r2; x++){
            double limit = Math.sqrt(r2*r2 - x*x);
            double start = Math.sqrt(Math.max(r1*r1-x*x, 0));
            long value1 = (long)start == start ? (long)start : (long)(start+1);
            long value2 = (long)limit;
            count += (value2-value1+1);
        }
        return 4 * (count - (r2-r1+1));
    }
}