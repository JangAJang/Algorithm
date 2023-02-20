import java.util.*;
import java.util.stream.Collectors;

class Solution {

    private static final HashMap<Integer, HashMap<String, Integer>> map = new HashMap<>();
    private static final Set<Integer> set = new HashSet<>();

    public String[] solution(String[] orders, int[] course) {
        for(int count : course){
            map.put(count, new HashMap<>());
            set.add(count);
        }
        for(String order : orders){
            order = sortOrder(order);
            dfs(order, new boolean[order.length()], new StringBuilder(), 0);
        }
        List<String> answer = new ArrayList<>();
        for(int length : course){
            int max = 0;
            for(String courseEach : map.get(length).keySet()){
                max = Math.max(max, map.get(length).get(courseEach));
            }
            if(max < 2) continue;
            for(String courseEach : map.get(length).keySet()){
                if(map.get(length).get(courseEach) == max)
                    answer.add(courseEach);
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void dfs(String order, boolean[] visited, StringBuilder sb, int startIndex) {
        if(set.contains(sb.length())){
            int count = map.get(sb.length()).getOrDefault(sb.toString(), 0) + 1;
            map.get(sb.length()).put(sb.toString(), count);
            if(sb.length() == new ArrayList<>(set).get(set.size()-1)) return;
        }
        for(int index = startIndex; index < order.length(); index++){
            if(visited[index]) continue;
            sb.append(order.charAt(index));
            visited[index] = true;
            dfs(order, visited,sb, index);
            visited[index] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private String sortOrder(String order){
        char[] separate = order.toCharArray();
        Arrays.sort(separate);
        return new String(separate);
    }
}