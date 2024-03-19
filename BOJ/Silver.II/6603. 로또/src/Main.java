import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Silver2. 로또
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        String input;
        StringBuilder sb = new StringBuilder();
        while(true) {
            input = br.readLine();
            if(input.equals("0")) {
                break;
            }
            sb.append(printCases(input)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String printCases(final String input) {
        String[] split = input.split(" ");
        int count = Integer.parseInt(split[0]);
        arr = new int[count];
        for(int index = 0; index < count; index++) {
            arr[index] = Integer.parseInt(split[index+1]);
        }
        StringBuilder sb = new StringBuilder();
        printCase(new boolean[count], 0, 0, sb);
        return sb.toString();
    }

    private static void printCase(final boolean[] visited, final int count, final int start, StringBuilder sb) {
        if(count == 6) {
            for(int index = 0; index < visited.length; index++) {
                if(visited[index]) {
                    sb.append(arr[index]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        if(start >= visited.length) return;

        for(int index = start; index < visited.length; index++) {
            if(visited[index]) continue;
            visited[index] = true;
            printCase(visited, count+1, index+1, sb);
            visited[index] = false;
        }
    }
}