import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bfs(values[0], values[1]);
        }
    }

    private static void bfs(int start, int target){
        String[] command = new String[10_000];
        boolean[] visited = new boolean[10_000];
        Queue<Integer> queue = new ArrayDeque<>();
        command[start] = "";
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            int dResult = doD(current);
            if(!visited[dResult]){
                command[dResult] = command[current] + "D";
                visited[dResult] = true;
                queue.add(dResult);
            }
            int sResult = doS(current);
            if(!visited[sResult]){
                command[sResult] = command[current] + "S";
                visited[sResult] = true;
                queue.add(sResult);
            }
            int lResult = doL(current);
            if(!visited[lResult]){
                command[lResult] = command[current] + "L";
                visited[lResult] = true;
                queue.add(lResult);
            }
            int rResult = doR(current);
            if(!visited[rResult]){
                command[rResult] = command[current] + "R";
                visited[rResult] = true;
                queue.add(rResult);
            }
        }
        System.out.println(command[target]);
    }

    private static int doD(int value){
        return (value*2)%10_000;
    }

    private static int doS(int value){
        return (value + 10_000 -1)% 10_000;
    }

    private static int doL(int value){
        return value / 1000 + (value % 1000) * 10;
    }

    private static int doR(int value){
        return value % 10 * 1000 + value / 10;
    }
}