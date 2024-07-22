package DailyQuestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortThePeople {

    public String[] sortPeople(String[] names, int[] heights) {
        final Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        List<String> people = map.keySet().stream().sorted(Comparator.comparingInt(height -> -1 * height)).map(each -> map.get(each)).toList();
        return people.toArray(new String[people.size()]);
    }
}
