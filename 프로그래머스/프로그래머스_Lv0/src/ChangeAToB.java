import java.util.HashMap;

public class ChangeAToB {
    // lv0. A로 B만들기
    class Solution {
        public int solution(String before, String after) {
            if(makeMap(before).equals(makeMap(after))) return 1;
            return 0;
        }

        private HashMap<String, Integer> makeMap(String string){
            HashMap<String, Integer> map = new HashMap<>();
            for(String each : string.split("")){
                if(!map.containsKey(each)) {
                    map.put(each, 1);
                    continue;
                }
                map.replace(each, map.get(each), map.get(each)+1);
            }
            return map;
        }
    }
}
