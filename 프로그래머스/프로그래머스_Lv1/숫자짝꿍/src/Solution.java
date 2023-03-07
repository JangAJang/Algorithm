class Solution {

    private int[] xCount;
    private int[] yCount;
    private StringBuilder result;

    public String solution(String X, String Y) {
        xCount = countNumbers(X);
        yCount = countNumbers(Y);
        return checkResult(getBiggestNum());
    }

    private String checkResult(String result){
        if(result.equals("")) return"-1";
        if(result.startsWith("0")) return "0";
        return result;
    }

    private String getBiggestNum(){
        result = new StringBuilder();
        for(int i = 9; i >=0; i--){
            appendNumberOnBuilder(i);
        }
        return result.toString();
    }

    private void appendNumberOnBuilder(int i){
        while(xCount[i] >0 && yCount[i] >0){
            xCount[i]--;
            yCount[i]--;
            result.append(i);
        }
    }

    private int[] countNumbers(String x){
        int[] counts = new int[10];
        for(String number : x.split("")){
            counts[Integer.parseInt(number)]++;
        }
        return counts;
    }
}