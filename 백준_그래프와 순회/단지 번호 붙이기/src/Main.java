import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    static int[][] arr;
    static boolean[][] visitied;
    static int count = 0;
    static int n;
    static int[] result;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visitied = new boolean[n+1][n+1];
        result = new int[(n+1)*(n+1)];
        for(int i=1; i<=n; i++){
            String s = br.readLine();
            for(int j=1; j<=n; j++){
                arr[i][j] = Character.getNumericValue(s.charAt(j-1));
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i][j] == 1 && !visitied[i][j]){
                    count++;
                    dfs(i, j);
                }
            }
        }
        Arrays.sort(result);
        System.out.println(count);
        for(int i=0; i<result.length; i++){
            if(result[i]!=0) System.out.println(result[i]);
        }
    }

    public static void dfs(int x, int y){
        visitied[x][y] = true;
        result[count]++;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        for(int i=0; i<4; i++){
            int finalX = x + dx[i];
            int finalY = x + dy[i];
            if(finalX >=0 && finalY >=0 && finalX <= n && finalY <= n){
                if(arr[finalX][finalY] == 1 && !visitied[finalX][finalY]){
                    dfs(finalX,finalY);
                }
            }
        }
    }
}
