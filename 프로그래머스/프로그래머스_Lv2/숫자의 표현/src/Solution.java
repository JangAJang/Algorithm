class Solution {

    private int count = 0;

    public int solution(int n) {
        getCountByN(n);
        return count;
    }

    private void getCountByN(int n){
        for(int startIndex = 1; startIndex <=n; startIndex++){
            getSumFromStart(startIndex, n);
        }
    }
    
    private void getSumFromStart(int startIndex, int n){
        int result = 0;
        for(int lastIndex = startIndex; lastIndex <=n; lastIndex++){
            result += lastIndex;
            addCount(result, n);
            if(result > n) break;
        }
    }

    private void addCount(int result, int n){
        if(result == n) {
            count++;
        }
    }
}