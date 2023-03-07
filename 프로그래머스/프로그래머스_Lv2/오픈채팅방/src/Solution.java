import java.util.*;
import java.util.stream.Collectors;

class Solution {

    private final HashMap<String, String> idMapper = new HashMap<>();

    public String[] solution(String[] record) {
        List<String> records =new ArrayList<>();
        for(String commandEach : record){
            putData(commandEach, records);
        }
        return records.stream().map(s-> idMapper.get(s.split("@")[0])+s.split("@")[1])
                .collect(Collectors.toList()).toArray(new String[records.size()]);
    }

    private void putData(String commandEach, List<String> records){
        putIdMapping(commandEach);
        String[] dataEach = commandEach.split(" ");
        if(dataEach[0].equals("Enter")) records.add(dataEach[1]+"@님이 들어왔습니다.");
        if(dataEach[0].equals("Leave")) records.add(dataEach[1]+"@님이 나갔습니다.");
    }

    private void putIdMapping(String commandEach){
        if(commandEach.split(" ").length < 3) return;
        if(!idMapper.containsKey(commandEach.split(" ")[1])) {
            idMapper.put(commandEach.split(" ")[1], commandEach.split(" ")[2]);
            return;
        }
        idMapper.replace(commandEach.split(" ")[1], commandEach.split(" ")[2]);
    }
}