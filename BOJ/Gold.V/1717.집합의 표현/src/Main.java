import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] parent;
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());
        int commandCount = Integer.parseInt(st.nextToken());
        parent = new int[count+1];
        IntStream.range(0, count+1).forEach(i -> parent[i] = i);
        while(commandCount-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(command == 0 ){
                union(a, b);
                continue;
            }
            if(getParent(a) == getParent(b)){
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }

    private static void union(int a, int b){
        int parentA = getParent(a);
        int parentB = getParent(b);
        if(parentA == parentB) return;
        parent[parentB] = parentA;
    }

    private static int getParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = getParent(parent[x]);
    }
}