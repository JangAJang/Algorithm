import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int LIMIT = 1_000_000_000;

    public int[] solution(long begin, long end) {
        int[] array = new int[(int)(end - begin)+1];
        for(int value = (int)begin; value <= end; value++){
            array[value - (int)begin] = getBiggestDivider(value);
        }
        return array;
    }

    private int getBiggestDivider(int value){
        if(value == 1) return 0;
        List<Integer> dividers = new ArrayList<>();
        for(int index = 1; index <= Math.sqrt(value); index++){
            if(value % index == 0) dividers.add(index);
        }
        for(int index = 1; index < dividers.size(); index++){
            if(value / dividers.get(index) <= 10_000_000) return value / dividers.get(index);
        }
        for(int index = dividers.size()-1; index >=1; index--){
            if(dividers.get(index) <= 10_000_000) return dividers.get(index);
        }
        return 1;
    }
}