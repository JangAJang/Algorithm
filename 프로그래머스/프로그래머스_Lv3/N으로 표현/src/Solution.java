import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

class Solution {
    public int solution(int N, int number) {
        HashMap<Integer, Set<Integer>> map = makeUntil2(N);
        if(N== number) return 1;
        for(int index = 2; index <=8; index++){
            Set<Integer> resultOfIndex = new HashSet<>();
            for(int start = 1; start < index; start++){
                resultOfIndex.addAll(makeNextSet(map.get(start), map.get(index - start), N));
            }
            if(resultOfIndex.contains(number)) return index;
            map.put(index, resultOfIndex);
        }
        return -1;
    }

    private Set<Integer> makeNextSet(Set<Integer> values, Set<Integer> others, int N) {
        Set<Integer> next = new HashSet<>();
        for(int value : values){
            for(int other : others){
                if(Pattern.matches(Integer.toString(N), Integer.toString(value)) &&
                        Pattern.matches(Integer.toString(N), Integer.toString(other)))
                    next.add(Integer.parseInt(Integer.toString(value).concat(Integer.toString(other))));
                next.add(value + other);
                next.add(value - other);
                next.add(value * other);
                if(other != 0) next.add(value / other);
            }
        }
        return next;
    }


    private HashMap<Integer, Set<Integer>> makeUntil2(int N){
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        set1.add(N);
        map.put(1, set1);
        return map;
    }
}