import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    private int values;
    private int xNumber;

    public String solution(String polynomial) {
        values = 0;
        xNumber = 0;
        countNumbers(Arrays.stream(polynomial.replace(" + ", " ").split(" ")).collect(Collectors.toList()));
        if(xNumber == 1 && values == 0) return "x";
        if(xNumber == 1) return "x + " + Integer.toString(values);
        if(values == 0) return Integer.toString(xNumber) + "x";
        if(xNumber == 0) return Integer.toString(values);
        return Integer.toString(xNumber) + "x + " + Integer.toString(values);
    }

    private void countNumbers(List<String> parts){
        for(String each : parts){
            if(each.contains("x")) {
                countXNumbers(each);
                continue;
            }
            countValues(each);
        }

    }

    private void countXNumbers(String each){
        if(each.equals("x")) {
            xNumber++;
            return;
        }
        xNumber += Integer.parseInt(each.replace("x",""));
    }

    private void countValues(String each){
        values += Integer.parseInt(each);
    }
}