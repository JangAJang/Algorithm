import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

// Gold2. 4195. 친구 네트워크
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] parent;
    private static int[] level;


    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());
        while(count-- > 0) {
            countNetwork();
        }
    }

    private static void countNetwork() throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> indexValue = new HashMap<>();
        parent = new int[2*n];
        level = new int[2*n];
        for(int index = 0; index < 2*n; index++) {
            parent[index] = index;
            level[index] = 1;
        }
        int count = 0;
        String[] command = new String[n];
        for(int index = 0; index < n; index++) {
            command[index] = br.readLine();
            String[] people = command[index].split(" ");
            if(!indexValue.containsKey(people[0])) {
                indexValue.put(people[0], count);
                count++;
            }
            if(!indexValue.containsKey(people[1])) {
                indexValue.put(people[1], count);
                count++;
            }
            System.out.println(union(indexValue.get(people[0]), indexValue.get(people[1])));
        }
    }

    private static int find(final int index) {
        if(parent[index] == index) return index;
        return parent[index] = find(parent[index]);
    }

    private static int union(final int a, final int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            parent[y] = x;
            level[x] += level[y]; 
            level[y] = 1;
        }

        return level[x];
    }
}