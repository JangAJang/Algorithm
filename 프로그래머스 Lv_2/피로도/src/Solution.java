import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    private static final int REQUIRED_FATIGUE_LEVEL = 0;
    private static final int USING_FATIGUE_LEVEL = 1;


    List<Integer> answers = new ArrayList<>();
    boolean[] visit;

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return answers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0);
    }

    private void dfs(int[][] dungeons, int k, int count){
        for(int index = 0; index < dungeons.length; index++){
            if(isAbleToGo(k, dungeons[index][REQUIRED_FATIGUE_LEVEL]) && isNewDungeon(index)) {
                visit[index] = true;
                dfs(dungeons, k - dungeons[index][USING_FATIGUE_LEVEL], count+1);
                visit[index] = false;
            }
        }
        answers.add(count);
    }

    private boolean isNewDungeon(int index){
        return !visit[index];
    }

    private boolean isAbleToGo(int fatigueLevel, int requiredFatigue){
        return fatigueLevel >= requiredFatigue;
    }
}