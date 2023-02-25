import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();
        int nodes = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        int[][] edge = new int[edges][3];
        for(int index = 0; index < edges; index++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int y = 0;y < 3; y++){
                edge[index][y] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution.solution(nodes, edge));
    }
}