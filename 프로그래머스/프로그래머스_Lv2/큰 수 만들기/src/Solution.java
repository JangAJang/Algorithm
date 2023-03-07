class Solution {

    private int limit;
    private int nextIndex = 0;

    public String solution(String number, int k) {
        limit = k;
        StringBuilder sb = new StringBuilder();
        for(int index = 0; index < number.length() - limit; index++){
            sb.append(getBiggestNumberAvailable(index, number));
        }
        return sb.toString();
    }

    private int getBiggestNumberAvailable(int index, String number){
        int result = 0;
        for(int numberIndex = nextIndex; numberIndex <= index+limit; numberIndex++){
            int value = number.charAt(numberIndex) - '0';
            if(result < value){
                result = value;
                nextIndex = numberIndex+1;
            }
        }
        return result;
    }
}