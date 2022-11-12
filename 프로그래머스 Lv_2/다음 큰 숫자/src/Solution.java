import java.util.Arrays;

class Solution {
    public int solution(int n) {
        return n+(n&-n)+(1<<Integer.bitCount(n)-Integer.bitCount(n+(n&-n)))-1;
    }

    private int getNextBigNumber(int n){
        int countOne = Integer.bitCount(n);
        if(countOne == Integer.toBinaryString(n).length()){
            return (int)(n - Math.pow(2, countOne-1) + Math.pow(2, countOne));
        }
        while(true){
            n++;
            if(Integer.bitCount(n) == countOne){
                return n;
            }
        }
    }
}