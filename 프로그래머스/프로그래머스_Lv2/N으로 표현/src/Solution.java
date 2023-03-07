import java.util.*;

class Solution {

    private static final Map<Integer, Set<Integer>> map = new HashMap<>();
    private static final int[] duplicated = new int[]{0, 1, 11, 111, 1111, 11111, 111111, 1111111, 11111111};

    public int solution(int N, int number) {
        if(N == number) return 1;
        for(int index = 1; index <= 8; index++){
            map.put(index, new HashSet<>());
            map.get(index).add(N*duplicated[index]);
        }
        for(int index = 2; index <= 8; index++){
            for(int firstIndex = 1; firstIndex < index; firstIndex++){
                for(int value : map.get(firstIndex)){
                    for(int next : map.get(index - firstIndex)){
                        map.get(index).add(value + next);
                        map.get(index).add(value - next);
                        map.get(index).add(value * next);
                        if(next != 0) map.get(index).add(value / next);
                    }
                }
            }
            if(map.get(index).contains(Integer.valueOf(number))){
                return index;
            }
        }
        return -1;
    }
}