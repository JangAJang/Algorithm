import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] citations) {
        return getHIndex(Arrays.stream(citations).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList()));
    }

    private int getHIndex(List<Integer> citations){
        for(int index = 0; index < citations.size(); index++){
            System.out.println(index + " "  + citations.get(index));
            if(index+1 >= citations.get(index)) return makeHIndex(citations, index);
        }
        return citations.size();
    }

    private int makeHIndex(List<Integer> citations, int index){
        if(index >= citations.get(index)) return index;
        return index+1;
    }
}