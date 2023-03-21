class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int lastPoint = 0;
        for(int index = 0; index < section.length; index++){
            if(lastPoint == 0 || lastPoint + m - 1 < section[index]) {
                lastPoint = section[index];
                count++;
            }
        }
        return count;
    }
}