import java.util.*;

class Solution {
    
    private double[][] sum;
    
    public double[] solution(int k, int[][] ranges) {
        List<Double> areaSum = getAreaSum(getCollatz(k));
        sum = new double[areaSum.size()+1][areaSum.size()+1];
        for(int index = 0; index < areaSum.size(); index++) {
            sum[index][index+1] = areaSum.get(index);
        }
        double[] result = new double[ranges.length];
        for(int index = 0; index < ranges.length; index++) {
            int start = ranges[index][0];
            int end = areaSum.size() + ranges[index][1];
            result[index] = getAccumulatedSum(start, end);
        }
        return result;
    }
    
    public double getAccumulatedSum(final int start, final int end) {
        if (start == end) return 0;
        if(sum[start][end] != 0) return sum[start][end];
        int mid = (start+end)/2;
        sum[start][end] = getAccumulatedSum(start, mid) + getAccumulatedSum(mid, end);
        return sum[start][end];
    }
    
    public List<Double> getCollatz(int k) {
        List<Double> list = new ArrayList<>();
        double collatz = k;
        list.add(collatz);
        while(collatz != 1) {
            if(collatz% 2 == 0) {
                collatz /=2;
                list.add(collatz);
                continue;
            }
            collatz = 3 * collatz + 1;
            list.add(collatz);
        }
        return list;
    }
    
    public List<Double> getAreaSum(final List<Double> collatz) {
        List<Double> list = new ArrayList<>();
        for(int index = 1; index < collatz.size(); index++) {
            double size = (collatz.get(index) + collatz.get(index-1))/2;
            list.add(size);
        }
        return list;
    }
}