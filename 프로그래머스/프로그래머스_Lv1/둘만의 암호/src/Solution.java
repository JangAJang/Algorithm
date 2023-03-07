import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    private final List<String> list = new ArrayList<>();

    public String solution(String s, String skip, int index) {
        addCharacterExcept(skip);
        return Arrays.stream(s.split("")).map( each ->
                list.get((list.indexOf(each) + index + list.size())%list.size())
        ).collect(Collectors.joining(""));
    }

    private void addCharacterExcept(String skip){
        List<String> skips = Arrays.stream(skip.split("")).collect(Collectors.toList());
        for(int index = 0; index < 26; index++){
            String character = Character.toString((char) ('a' + index));
            if(!skips.contains(character)) list.add(character);
        }
    }
}