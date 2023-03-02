
import java.io.*;
import java.util.*;

public class Main{

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws Exception{
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            Solution solution = new Solution();
            solution.doCase();
        }
    }

    static class Solution{
        private void doCase()throws Exception{
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            boolean[][] link = new boolean[n+1][n+1];
            int[] parent = new int[n+1];
            int[] time = new int[n+1];
            st = new StringTokenizer(br.readLine(), " ");
            for(int index = 1; index <=n; index++){
                time[index] = Integer.parseInt(st.nextToken());
            }
            while(e-->0){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                link[start][end] = true;
                parent[end]++;
            }
            int target = Integer.parseInt(br.readLine());
            System.out.println(calculateTime(link, time, parent)[target]);
        }

        private int[] calculateTime(boolean[][] link, int[] time, int[] parent){
            Queue<Integer> queue = new ArrayDeque<>();
            int[] result = new int[parent.length];
            for(int index = 1; index < time.length; index++){
                if(parent[index] == 0){
                    result[index] = time[index];
                    queue.add(index);
                }
            }
            while(!queue.isEmpty()){
                int current = queue.poll();
                for(int index = 1; index < time.length; index++){
                    if(link[current][index]){
                        result[index] = Math.max(result[index], result[current] + time[index]);
                        --parent[index];
                        if(parent[index] == 0){
                            queue.add(index);
                        }
                    }
                }
            }
            return result;
        }
    }
}