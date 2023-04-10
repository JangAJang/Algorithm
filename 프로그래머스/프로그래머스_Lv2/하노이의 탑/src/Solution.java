    import java.util.*;
    import java.util.stream.*;

    class Solution {

        private static final List<int[]> result = new ArrayList<>();

        public int[][] solution(int n) {
            dfs(n, 1, 3, 2);
            int[][] answer = new int[result.size()][2];
            for(int index = 0; index < answer.length; index++){
                answer[index] = Arrays.copyOf(result.get(index), 2);
            }
            return answer;
        }

        private static void dfs(int n, int start, int to, int mid){
            if(n == 1){
                result.add(new int[]{start, to});
                return;
            }
            dfs(n-1, start, mid, to);
            result.add(new int[]{start, to});
            dfs(n-1, mid, to, start);
        }
    }