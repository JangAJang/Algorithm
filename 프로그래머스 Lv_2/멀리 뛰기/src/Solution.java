class Solution {

    private Long[] cases;

    public long solution(int n) {
        initializeCases(n);
        countAllCases(n);
        return cases[n];
    }

    private void initializeCases(int n){
        cases = new Long[n+1];
        cases[0] = 1L;
        cases[1] = 1L;
    }

    private void countAllCases(int n){
        for(int distance = 2; distance <=n; distance++){
            countCasesOn(distance);
        }
    }

    private void countCasesOn(int x){
        cases[x] = (cases[x-1] + cases[x-2]) % 1234567;
    }
}