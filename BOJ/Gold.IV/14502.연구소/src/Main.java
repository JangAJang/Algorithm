import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();
        solution.solution();
    }

    static class Solution{
        private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;
        private int[][] arr;
        private int result = 0;
        private List<List<Integer>> combinations = new ArrayList<>();
        private static final int[] xMove = new int[]{-1, 1, 0, 0};
        private static final int[] yMove = new int[]{0, 0, -1, 1};

        public void solution()throws Exception{
            List<int[]> empty = new ArrayList<>();
            List<int[]> virus = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            int wallCount = 0;
            for(int x = 0; x < n; x++){
                String[] line = br.readLine().split(" ");
                for(int y = 0; y < m; y++){
                    arr[x][y] = Integer.parseInt(line[y]);
                    if(arr[x][y] == 0) {
                        empty.add(new int[]{x, y});
                        continue;
                    }
                    if(arr[x][y] == 1) {
                        wallCount++;
                        continue;
                    }
                    virus.add(new int[]{x, y});
                }
            }
            nCr(empty.size(), new boolean[empty.size()], 0, 3);
            for(List<Integer> comb : combinations){
                int count = countSafe(comb, empty, virus);
                result = Math.max(result, n*m - wallCount - count - 3);
            }
            System.out.println(result);
        }

        private int countSafe(List<Integer> comb, List<int[]> empty, List<int[]> virus){
            Queue<int[]> queue = new ArrayDeque<>(virus);
            boolean[][] visited = new boolean[arr.length][arr[0].length];
            for(int indexOf : comb){
                int[] spot = empty.get(indexOf);
                arr[spot[0]][spot[1]] = 1;
            }
            while(!queue.isEmpty()){
                int[] current = queue.poll();
                visited[current[0]][current[1]] = true;
                for(int index = 0; index < 4; index++){
                    int x = current[0] + xMove[index];
                    int y = current[1] + yMove[index];
                    if(x < 0 || x >= visited.length || y < 0 || y >= visited[0].length ) continue;
                    if(visited[x][y]) continue;
                    if(arr[x][y] == 1) continue;
                    queue.add(new int[]{x, y});
                }
            }
            for(int indexOf : comb){
                int[] spot = empty.get(indexOf);
                arr[spot[0]][spot[1]] = 0;
            }
            int count = 0;
            for(int x = 0; x < visited.length; x++){
                for(int y = 0; y < visited[0].length; y++){
                    if(visited[x][y]) count++;
                }
            }
            return count;
        }

        private void nCr(int size, boolean[] visited, int start, int r) {
            if( r== 0 ){
                addComb(visited);
                return;
            }
            for(int index = start; index < size; index++){
                visited[index] = true;
                nCr(size, visited, index+1, r-1);
                visited[index] = false;
            }
        }

        private void addComb(boolean[] visited){
            List<Integer> list = new ArrayList<>();
            for(int index = 0; index < visited.length; index++){
                if(visited[index]) list.add(index);
            }
            combinations.add(list);
        }
    }
}