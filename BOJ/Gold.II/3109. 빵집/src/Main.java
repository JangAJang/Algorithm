import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    // Gold2. 3109 빵집

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] xMove = new int[]{-1, 0, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        boolean[][] canVisit = new boolean[Y][X];
        for(int x = 0; x < X; x++) {
            String input = br.readLine();
            for(int y = 0; y < Y; y++) {
                canVisit[y][x] = input.charAt(y) == '.';
            }
        }

        int[] arr = new int[Y-1];
        for(int index = 0; index < Y-1; index++) {
            arr[index] = findMovableCases(canVisit[index], canVisit[index+1]);
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }

    private static int findMovableCases(final boolean[] firstLine, final boolean[] secondLine) {
        boolean[] visited = new boolean[secondLine.length];
        for(int index = 0; index < firstLine.length; index++) {
            if(!firstLine[index])continue;
            for(int choice = 0; choice < 3; choice++) {
                int nextX = xMove[choice] + index;
                if(nextX < 0 || nextX >= firstLine.length) continue;
                if(!secondLine[nextX]) continue;
                visited[nextX] = true;
            }
        }
        int count = 0;
        for(boolean each : visited) {
            if(each) count++;
        }
        return count;
    }
}