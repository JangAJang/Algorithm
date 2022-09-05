import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int max = 100000;
    static int start;
    static int end;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        visited = new boolean[max+1];
        bfs();
        System.out.println(min);
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        while(!q.isEmpty()){
            Node node = q.poll();
            visited[node.location] = true;
            if(node.location == end)min = Math.min(min, node.time);
            if(node.location *2 <= max && !visited[node.location*2]) q.offer(new Node(node.location*2, node.time));
            if(node.location +1 <= max && !visited[node.location+1]) q.offer(new Node(node.location+1, node.time+1));
            if(node.location -1 >=0 && !visited[node.location-1]) q.offer(new Node(node.location-1, node.time+1));

        }
    }

    public static class Node{
        int location;
        int time;
        public Node(int loc, int time){
            this.location = loc;
            this.time = time;
        }
    }
}
