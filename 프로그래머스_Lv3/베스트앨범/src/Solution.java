import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int index = 0; index < genres.length; index++){
            if(!map.containsKey(genres[index]))
                map.put(genres[index], new ArrayList<>());
            map.get(genres[index]).add(index);
        }
        for(String genre : map.keySet()){
            map.get(genre).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return plays[t1] - plays[integer];
                }
            });
        }
        List<String> orders = map.keySet().stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                int result1 = 0;
                int result2 = 0;
                for(int index : map.get(s)){
                    result1 += plays[index];
                }
                for(int index : map.get(t1)){
                    result2 += plays[index];
                }
                return - result1 + result2;
            }
        }).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for(String genre : orders){
            for(int index = 0; index < Math.min(2, map.get(genre).size()); index++){
                result.add(map.get(genre).get(index));
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}