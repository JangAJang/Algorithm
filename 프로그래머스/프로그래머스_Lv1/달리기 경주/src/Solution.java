import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int index = 0; index < players.length; index++){
            map.put(players[index], index);
        }
        for(String calling : callings){
            int rank = map.get(calling);
            String tmp = players[rank-1];
            map.replace(tmp, map.get(tmp), map.get(tmp)+1);
            map.replace(calling, map.get(calling), map.get(calling)-1);
            players[rank] = tmp;
            players[rank-1] = calling;
        }
        return players;
    }
}