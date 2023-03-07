class Solution {
    public int solution(String t, String p) {
        int result = 0;
        for(int index = 0; index < t.length() - p.length()+1; index++){
            result += Long.parseLong(t.substring(index, index+p.length())) <= Long.parseLong(p) ? 1 : 0;
        }
        return result;
    }
}