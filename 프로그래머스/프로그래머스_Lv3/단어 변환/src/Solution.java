import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    private List<String> wordList;

    public int solution(String begin, String target, String[] words) {
        wordList = Arrays.stream(words).collect(Collectors.toList());
        if(!wordList.contains(target)) return 0;
        return dfs(begin, target, new boolean[words.length], 0, Integer.MAX_VALUE);
    }

    private int dfs(String begin, String target, boolean[] visited, int cnt, int ans) {
        if (begin.equals(target)) {
            return cnt;
        }
        for (int index = 0; index < wordList.size(); index++) {
            if (!visited[index] && isOnlyOneDifferent(begin, wordList.get(index))) {
                visited[index] = true;
                ans = Math.min(ans, dfs(wordList.get(index), target, visited, cnt + 1, ans));
                visited[index] = false;
            }
        }
        return ans;
    }

    private boolean isOnlyOneDifferent(String current, String next) {
        int differentCnt = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != next.charAt(i)) {
                differentCnt++;
            }
        }
        return differentCnt == 1;
    }
}