import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int index = 0; index < want.length; index++){
            map.put(want[index], number[index]);
        }
        int result = 0;
        for(int index = 0; index < discount.length-9; index++){
            String[] items = Arrays.copyOfRange(discount, index, index+10);
            int count = 0;
            for(String itemEach : map.keySet()){
                if(Arrays.stream(items).filter(s-> s.equals(itemEach)).count() == map.get(itemEach)) count++;
            }
            if(count == map.size()) result++;
        }
        return result;
    }
}