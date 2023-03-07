import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] solution(String s) {
        return sortNumberByCount(countNumbersFromS(s));
    }

    private int[] sortNumberByCount(HashMap<Integer, Integer> counted){
        return counted.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private HashMap<Integer, Integer> countNumbersFromS(String s){
        HashMap<Integer, Integer> counted = new HashMap<>();
        for(int numberEach : makeNumbers(s)){
            addNumber(counted, numberEach);
        }
        return counted;
    }

    private void addNumber(HashMap<Integer, Integer> counted, int numberEach){
        if(!counted.containsKey(numberEach)) {
            counted.put(numberEach, 1);
            return;
        }
        counted.replace(numberEach, counted.get(numberEach), counted.get(numberEach)+1);
    }

    private int[] makeNumbers(String s){
        String[] deleted = deleteBrackets(s.split(","));
        return getValue(deleted);
    }

    private String[] deleteBrackets(String[] split){
        for(int index = 0; index < split.length; index++){
            split[index] = split[index].replaceAll("[{}]", "");
        }
        return split;
    }

    private int[] getValue(String[] deleted){
        return Arrays.stream(deleted).mapToInt(Integer::parseInt).toArray();
    }
}