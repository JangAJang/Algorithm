import java.util.*;
import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int [G+1];

        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        System.out.println(countPossibleGates(P));
    }

    private static int countPossibleGates(int P) throws IOException {
        int answer = 0;

        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int emptyGate = find(g);

            if (emptyGate == 0) {
                break;
            }

            answer++;
            union(emptyGate, emptyGate - 1);
        }

        return answer;
    }

    private static int find(final int a) {
        if( a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(final int a, final int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) {
            return;
        }

        if( parentA < parentB) {
            parent[b] = parentA;
            return;
        }

        parent[a] = parentB;
    }
}