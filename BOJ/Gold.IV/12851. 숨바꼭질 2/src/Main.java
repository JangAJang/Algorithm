import java.util.*;
import java.io.*;

class Main {
    static int[] time = new int[100001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }
        bfs(N, K);
        System.out.println(minTime + "\n" + count);
    }

    private static void bfs(int N, int K) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        time[N] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (minTime < time[now]) return;
            for (int i=0; i<3; i++) {
                int next = getNext(now, i);
                if (next < 0 || next > 100000) continue;
                if (next == K) {
                    minTime = time[now];
                    count++;
                }
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    q.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }

    private static int getNext(int now, int i){
        if (i == 0) return now + 1;
        if (i == 1) return now - 1;
        return now * 2;
    }
}