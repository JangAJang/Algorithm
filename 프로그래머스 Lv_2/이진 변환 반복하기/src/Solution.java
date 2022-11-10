class Solution {

    private int zeroCount = 0;
    private int repeatCount = 0;

    public int[] solution(String s) {
        return repeatConvert(s);
    }

    private int[] repeatConvert(String s){
        if(s.equals("1")) return new int[]{repeatCount, zeroCount};
        return repeatConvert(changeLengthToBinary(deleteZero(s).length()));
    }

    private String deleteZero(String s){
        repeatCount++;
        String deleted = s.replaceAll("0", "");
        zeroCount += s.length() - deleted.length();
        return deleted;
    }

    private String changeLengthToBinary(int length){
        return Integer.toBinaryString(length);
    }
}