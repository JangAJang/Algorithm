import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int[] parent = new int[100001];
    public static int[] time = new int[100001];
    public static int subin, brother;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
        bfs();
        Stack<Integer> stack = new Stack<>();
        stack.push(brother);
        int index = brother;
        while(index != subin){
            stack.push(parent[index]);
            index = parent[index];
        }
        sb.append(time[brother] - 1 + "\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(subin);
        time[subin] = 1;
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == brother) return;
            int[] next = new int[3];
            next[0] = now + 1;
            next[1] = now -1;
            next[2] = now*2;
            for(int i=0; i<3; i++){
                if(next[i] <0 || next[i] > 100000) continue;
                if(time[next[i]] == 0){
                    queue.add(next[i]);
                    time[next[i]] = time[now] + 1;
                    parent[next[i]] = now;
                }
            }
        }
    }
}
