import java.util.*;
import java.util.stream.Collectors;

class Solution {

    private final HashMap<String, Integer> yNumbers = new HashMap<>();
    private final HashMap<String, Integer> xNumbers = new HashMap<>();
    private final HashMap<String, Integer> commonNumbers = new HashMap<>();


    public String solution(String X, String Y) {
        setOnHashMap(X, Y);
        getCommonNumbers();
        return makeCommonNumbersToString();
    }

    private String makeCommonNumbersToString(){
        if(commonNumbers.size() == 0) return "-1";
        if(commonNumbers.size() == 1 && commonNumbers.containsKey("0")) return "0";
        return makeStringByMap();
    }

    private String makeStringByMap(){
        List<String> numbers = getNumbersListSorted();
        String answer = "";
        for(String number : numbers){
            answer = answer.concat(getNumberDuplicated(number));
        }
        return answer;
    }

    private List<String> getNumbersListSorted(){
        return commonNumbers.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private String getNumberDuplicated(String number){
        String numbers = "";
        for(int i=0; i<commonNumbers.get(number); i++){
            numbers = numbers.concat(number);
        }
        return numbers;
    }

    private void getCommonNumbers(){
        for(int i=0; i<=9; i++){
            addToMapIfMapsContain(i);
        }
    }

    private void addToMapIfMapsContain(int i){
        String number = Integer.toString(i);
        if(yNumbers.containsKey(number) && xNumbers.containsKey(number)){
            addNumberInCommon(number);
        }
    }

    private void addNumberInCommon(String number){
        int count = Math.min(yNumbers.get(number), xNumbers.get(number));
        commonNumbers.put(number, count);
    }

    private void setOnHashMap(String x, String y){
        setHashOnX(x);
        setHashOnY(y);

    }

    private void setHashOnX(String number){
        for(String each : number.split("")){
            addEachOnHashX(each);
        }
    }

    private void addEachOnHashX(String each){
        if(xNumbers.containsKey(each)) {
            xNumbers.replace(each, xNumbers.get(each), xNumbers.get(each)+1);
            return;
        }
        xNumbers.put(each, 1);
    }

    private void setHashOnY(String number){
        for(String each : number.split("")){
            addEachOnHashY(each);
        }
    }

    private void addEachOnHashY(String each){
        if(yNumbers.containsKey(each)) {
            yNumbers.replace(each, yNumbers.get(each), yNumbers.get(each)+1);
            return;
        }
        yNumbers.put(each, 1);
    }
}
