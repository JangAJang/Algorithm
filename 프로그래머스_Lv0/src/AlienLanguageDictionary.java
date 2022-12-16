import java.util.Arrays;

public class AlienLanguageDictionary {
    // lv0. 외계어 사전
    class Solution {
        public int solution(String[] spell, String[] dic) {
            Arrays.sort(spell);
            for(String each : dic){
                if(Arrays.equals(spell, Arrays.stream(each.split("")).sorted().toArray())) return 1;
            }
            return 2;
        }
    }
}
