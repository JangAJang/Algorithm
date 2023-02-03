import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    private List<String> result = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        for(int index = 0; index < tickets.length; index++){
            if(tickets[index][0].equals("ICN")){
                dfs(index, tickets);
            }
        }
        return result.toArray(new String[0]);
    }

    private void dfs(int index, String[][] tickets) {
        Stack<List<Integer>> routes = new Stack<>();
        routes.push(List.of(index));
        while(!routes.isEmpty()){
            List<Integer> routeUntilNow = routes.pop();
            if(routeUntilNow.size() == tickets.length){
                List<String> dfsResult = makeToRouteName(tickets, routeUntilNow);
                result = new ArrayList<>(getFormerResult(result, dfsResult));
            }
            int lastIndex = routeUntilNow.get(routeUntilNow.size()-1);
            for(int count = 0; count < tickets.length; count++){
                if(!routeUntilNow.contains(count) && tickets[lastIndex][1].equals(tickets[count][0])){
                    List<Integer> nextRoute = new ArrayList<>(routeUntilNow);
                    nextRoute.add(count);
                    routes.push(nextRoute);
                }
            }
        }
    }

    private List<String> getFormerResult(List<String> result, List<String> dfs) {
        if(result.isEmpty()) return dfs;
        for(int index = 0; index < result.size(); index++){
            if(dfs.get(index).compareTo(result.get(index)) < 0) return dfs;
        }
        return result;
    }

    private List<String> makeToRouteName(String[][] tickets, List<Integer> routeUntilNow) {
        List<String> result = new ArrayList<>();
        for(int routeEach : routeUntilNow){
            result.add(tickets[routeEach][0]);
        }
        result.add(tickets[routeUntilNow.get(routeUntilNow.size()-1)][1]);
        return result;
    }
}