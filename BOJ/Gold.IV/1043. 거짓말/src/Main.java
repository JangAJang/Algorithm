import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] parent;

    //gold.4 1043 거짓말
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        IntStream.range(0, n+1).forEach(i -> parent[i] = i);
        groupKnowingPeople();
        List<int[]> list = new ArrayList<>();
        while(m-- > 0){
            int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(people);
            for(int index = 2; index < people.length; index++){
                union(people[1], people[index]);
            }
        }
        int count = 0;
        for(int[] each : list) {
            if(getParent(each[1]) != 0) count++;
        }
        System.out.println(count);
    }

    private static void groupKnowingPeople()throws IOException{
        int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if(people[0] == 0) return;
        IntStream.range(1, people[0]+1).forEach(i -> union(0, people[i]));
    }

    private static void union(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a > b) {
            parent[a] = b;
            return;
        }
        parent[b] = a;
    }

    private static int getParent(int n){
        if(n == parent[n]) return n;
        return parent[n] = getParent(parent[n]);
    }
}