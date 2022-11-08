class Solution {
    public String solution(String s) {
        return getMaxAndMin(s);
    }

    private String getMaxAndMin(String s){
        String[] eachMade = s.split(" ");
        Long min = Long.MAX_VALUE;
        Long max = Long.MIN_VALUE;
        for(String number: eachMade){
            min = Math.min(Long.parseLong(number), min);
            max = Math.max(Long.parseLong(number), max);
        }
        return min+ " " + max;
    }
}