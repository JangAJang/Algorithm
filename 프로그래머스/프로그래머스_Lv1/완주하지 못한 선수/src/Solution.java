import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion){
        HashMap<String, Integer> result = includeParticipant(participant);
        excludeCompletion(completion, result);
        return getLeft(result);
    }

    private HashMap<String, Integer> includeParticipant(String[] par){
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : par){
            includePersonToMap(s, map);
        }
        return map;
    }

    private void includePersonToMap(String s, HashMap<String, Integer> map){
        int count = 0;
        if(map.containsKey(s)){
            count = map.get(s);
            map.remove(s);
        }
        map.put(s, count+1);
    }

    private void excludeCompletion(String[] com, HashMap<String, Integer> map){
        for(String s : com){
            map.replace(s, map.get(s), map.get(s)-1);
        }
    }

    private String getLeft(HashMap<String, Integer> map){
        for(String s : map.keySet()){
            if(map.get(s)!=0) return s;
        }
        return "";
    }
}
