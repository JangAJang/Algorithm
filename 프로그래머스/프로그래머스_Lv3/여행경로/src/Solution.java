import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    private final List<String> route = new ArrayList<>();
    private boolean[] visited;
    private List<String> result = List.of("J");

    public String[] solution(String[][] tickets) {
        route.add("ICN");
        visited = new boolean[tickets.length];
        dfs(0, tickets, "ICN");
        return result.toArray(new String[0]);
    }

    private void dfs(int count, String[][] tickets, String start){
        if(count == tickets.length){
            if(String.join("", result).compareTo(String.join("", route)) > 0)
                result = new ArrayList<>(route);
        }
        for(int index = 0; index < tickets.length; index++){
            if(!visited[index] && tickets[index][0].equals(start)){
                visited[index] = true;
                route.add(tickets[index][1]);
                dfs(count+1, tickets, tickets[index][1]);
                visited[index] = false;
                route.remove(route.size()-1);
            }
        }
    }
}