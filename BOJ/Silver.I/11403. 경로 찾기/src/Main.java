import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[n][n];
        for(int x = 0; x < n; x++){
            arr[x] = Arrays.copyOf(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray(), n);
        }
        for(int k = 0; k< n; k++){
            for(int x = 0; x < n; x++){
                if(arr[x][k] == 0) continue;
                for(int y = 0; y<n; y++){
                    if(arr[k][y] == 1) arr[x][y] = 1;
                }
            }
        }
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                sb.append(arr[x][y]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println( sb.toString());
    }
}