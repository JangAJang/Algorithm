import java.util.*;
import java.io.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long count = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long from = Long.parseLong(st.nextToken());
        long to = Long.parseLong(st.nextToken());
        bfs(from, to);
        if(count == Integer.MAX_VALUE) count = -1;
        System.out.println(count);
    }

    private static void bfs(long from, long to){
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(new Node(from, 1));
        while(!nodes.isEmpty()){
            Node current = nodes.poll();
            if(current.getValue() == to){
                count = Math.min(count, current.getCount());
                continue;
            }
            Node next1 = new Node(current.getValue()*2, current.getCount()+1);
            if(next1.getValue() <= to) nodes.add(next1);
            Node next2 = new Node(current.getValue()*10+1, current.getCount()+1);
            if(next2.getValue() <= to) nodes.add(next2);
        }
    }

    static class Node{
        private final long value;
        private final long count;

        public Node(long value, long count) {
            this.value = value;
            this.count = count;
        }

        public long getValue() {
            return value;
        }

        public long getCount() {
            return count;
        }
    }
}