import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        IntStream.range(0, name.length).forEach( i -> scoreMap.put(name[i], yearning[i]));
        int[] answer = new int[photo.length];
        for(int index = 0; index < photo.length; index++){
            answer[index] = scorePhoto(photo[index], scoreMap);
        }
        return answer;
    }

    private int scorePhoto(String[] photoEach, HashMap<String, Integer> scoreMap) {
        int result = 0;
        for(String person : photoEach){
            result += scoreMap.getOrDefault(person, 0);
        }
        return result;
    }
}