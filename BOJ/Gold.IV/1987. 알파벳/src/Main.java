import java.util.*;
import java.io.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] xMove = new int[]{-1, 1, 0, 0};
    private static final int[] yMove = new int[]{0, 0, -1, 1};

    private static int result = 0;

    public static void main(String[] args)throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        Set<Character> alphabets = new HashSet<>();
        char[][] arr = new char[X][Y];
        for(int x = 0; x < X; x++){
            String line = br.readLine();
            for(int y = 0; y < Y; y++){
                arr[x][y] = line.charAt(y);
                alphabets.add(arr[x][y]);
            }
        }
        Map<Character, Boolean> visited = new HashMap<>();
        for(char alphabet : alphabets){
            visited.put(alphabet, false);
        }
        visited.replace(arr[0][0], true);
        checkCases(visited, arr, new Node(0, 0, 1));
        System.out.println(result);
    }

    private static void checkCases(Map<Character, Boolean> visited, char[][] arr, Node current){
        for(int index = 0; index < 4; index++){
            int x = current.getX() + xMove[index];
            int y = current.getY() + yMove[index];
            if(x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) continue;
            if(visited.get(arr[x][y])) continue;
            visited.replace(arr[x][y], true);
            checkCases(visited, arr, new Node(x, y, current.getCount()+1));
            visited.replace(arr[x][y], false);
        }
        result = Math.max(result, current.getCount());
    }

    static class Node{

        private int x;
        private int y;
        private int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }
    }
}