import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Gold2. 17136 색종이
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] xMove = new int[]{0, 1};
    private static final int[] yMove = new int[]{1, 0};


    private static final int SIZE = 10;
    private static boolean[][] arr;

    private static int answer;

    public static void main(String[] args) throws IOException {
        arr = new boolean[SIZE][SIZE];
        StringTokenizer st;
        answer = Integer.MAX_VALUE;
        for(int x = 0; x < SIZE; x++) {
            st = new StringTokenizer(br.readLine());
            for(int y = 0; y < SIZE; y++) {
                arr[x][y] = st.nextToken().equals("1");
            }
        }
        System.out.println(answer);
    }

    private static void countPossibleCases(final int count, final int x, final int y) {

        if(!arr[x][y]) {
            int nextY = (y + 1)%10;
            int nextX = x + (y + 1)/10;
            countPossibleCases(count, nextX, nextY);
        }
        for(int size = 0; size < 5; size++) {
            if(canMakeArrSize(size+1, x, y)) {
                int nextY = (y + size + 1)%10;
                int nextX = x + (y + size + 1)/10;
                countPossibleCases(count+1, nextX, nextY);
            }
        }
    }

    private static boolean canMakeArrSize(final int size, final int x, final int y) {
        if(x + size >= SIZE || y + size >= SIZE) return false;
        for(int nextX = x; nextX < x + size; nextX++) {
            for(int nextY = y; nextY < y + size; nextY++) {
                if(!arr[nextX][nextY]) return false;
            }
        }
        return true;
    }
}