import java.util.*;
import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int size = Integer.parseInt(br.readLine());
        HashMap<Integer, Set<Integer>> tree = makeTree(size);
        int[] result = getParentByDFS(tree, size);
        for(int index = 2; index <= size; index++){
            System.out.println(result[index]);
        }
    }

    private static int[] getParentByDFS(HashMap<Integer, Set<Integer>> tree, int size){
        int[] result = new int[size+1];
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[size+1];
        stack.push(1);
        while(!stack.isEmpty()){
            int current = stack.pop();
            visited[current] = true;
            Set<Integer> nextList = tree.get(current);
            for(int next : nextList){
                if(!visited[next]){
                    result[next] = current;
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
        return result;
    }

    private static HashMap<Integer, Set<Integer>> makeTree(int size) throws IOException{
        HashMap<Integer, Set<Integer>> edges = new HashMap<>();
        for(int index = 1; index <=size; index++){
            edges.put(index, new HashSet<>());
        }
        for(int index = 0; index < size -1 ; index++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges.get(a).add(b);
            edges.get(b).add(a);
        }
        return edges;
    }
}