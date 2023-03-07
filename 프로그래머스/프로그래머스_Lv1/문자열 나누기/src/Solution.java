class Solution {

    private int same = 1;
    private int different = 0;
    private int answer = 0;
    private char base;

    public int solution(String s) {
        base = s.charAt(0);
        for(int index = 1; index < s.length(); index++){
            if(base == '!'){
                base = s.charAt(index);
                continue;
            }
            if( s.charAt(index) == base) same++;
            else different++;
            if(same == different){
                answer++;
                refreshData();
            }
        }
        if(base != '!') answer++;
        return answer;
    }

    private void refreshData(){
        base = '!';
        same = 1;
        different = 0;
    }
}