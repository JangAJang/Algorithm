import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] count = new int[n+1];
        Node[] nodes = new Node[n+1];
        IntStream.range(0, n+1).forEach(i -> nodes[i] = new Node());
        Queue<Integer> queue = new ArrayDeque<>();
        while(e-- > 0){
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int index = 2; index < inputs.length; index++){
                if(!nodes[inputs[index-1]].getNext().contains(inputs[index])){
                    nodes[inputs[index-1]].addNode(inputs[index]);
                    count[inputs[index]]++;
                }
            }
        }
        for(int index = 1; index <=n; index++){
            if(count[index] == 0) queue.add(index);
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);
            for(int next : nodes[current].getNext()){
                count[next]--;
                if(count[next] == 0) queue.add(next);
            }
        }
        if(result.size() != n){
            System.out.println(0);
            return;
        }
        for(int each : result){
            System.out.println(each);
        }
    }

    static class Node{
        private static final Set<Integer> next = new HashSet<>();

        public Set<Integer> getNext(){
            return this.next;
        }

        public void addNode(int next){
            this.next.add(next);
        }
    }
}