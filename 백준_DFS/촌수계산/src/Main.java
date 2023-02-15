import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int people = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int relations = Integer.parseInt(br.readLine());
        HashMap<Integer, Set<Integer>> tree = makeTree(people, relations);
        System.out.println(countDistanceFromTo(tree, from, to));
    }

    private static int countDistanceFromTo(HashMap<Integer, Set<Integer>> tree, int from, int to){
        boolean[] visited = new boolean[tree.keySet().size()+1];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{from, 0});
        while(!stack.isEmpty()){
            int[] current = stack.pop();
            if(current[0] == to) return current[1];
            if(visited[current[0]]) continue;
            visited[current[0]] = true;
            for(int next : tree.get(current[0])){
                if(visited[next]) continue;
                stack.push(new int[]{next, current[1]+1});
            }
        }
        return -1;
    }

    private static HashMap<Integer, Set<Integer>> makeTree(int people, int relations)throws IOException{
        HashMap<Integer, Set<Integer>> tree = new HashMap<>();
        IntStream.range(1, people+1).forEach(i -> tree.put(i, new HashSet<>()));
        StringTokenizer st;
        while(relations-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            tree.get(parent).add(child);
            tree.get(child).add(parent);
        }
        return tree;
    }
}