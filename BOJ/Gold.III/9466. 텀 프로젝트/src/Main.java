import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/9466

class Main {

    static int n;
    static int[] arr;
    static int count = 0;
    static boolean[] visited;
    static boolean[] finished;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            countNotMembers();
        }
    }

    private static void countNotMembers() throws IOException{
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];
        finished = new boolean[n+1];
        count = 0;
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        IntStream.range(1, n+1).forEach(i -> arr[i] = nums[i-1]);
        IntStream.range(1, n+1).forEach(Main::dfs);
        System.out.println(n - count);
    }

    static void dfs(int now) {
        if(visited[now])
            return;
        visited[now] = true;
        int next = arr[now];
        if(!visited[next])
            dfs(next);
        else {
            if(!finished[next]) {
                count++;
                for(int i=next; i != now; i = arr[i])
                    count++;
            }
        }
        finished[now] = true;
    }
}