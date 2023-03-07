import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String key : keymap){
            map.put(key, Arrays.stream(key.split("")).collect(Collectors.toList()));
        }
        int[] result = new int[targets.length];
        for(int index = 0; index < targets.length; index++){
            String[] split = targets[index].split("");
            int totalCount = 0;
            for(String alphabet : split){
                int count = Integer.MAX_VALUE;
                for(String key : map.keySet()){
                    if(key.contains(alphabet)){
                        count = Math.min(count, map.get(key).indexOf(alphabet) + 1);
                    }
                }
                if(count == Integer.MAX_VALUE) continue;
                totalCount += count;
            }
            if(totalCount == 0) totalCount = -1;
            result[index] = totalCount;
        }
        return result;
    }
}