import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{

    private static int result = 0;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] field = new int[505][505];
        for(int x = 0; x < n; x++){
            int[] value = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for(int y = 0; y < m; y++){
                field[x][y] = value[y];
            }
        }
        for(int x = 0; x <n; x++){
            for(int y = 0; y <m; y++){
                checkField(field, x, y);
            }
        }
        System.out.println(result);
    }

    private static void checkField(int[][] a, int i, int j){
        compare(a[i][j]+a[i][j+1]+a[i][j+2]+a[i][j+3]); //case1
        compare(a[i][j]+a[i+1][j]+a[i+2][j]+a[i+3][j]); //case2
        compare(a[i][j]+a[i][j+1]+a[i+1][j]+a[i+1][j+1]); //case3
        compare(a[i][j]+a[i+1][j]+a[i+2][j]+a[i+2][j+1]); //case4
        compare(a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j]); //case5
        compare(a[i][j]+a[i][j+1]+a[i+1][j+1]+a[i+2][j+1]); //case6
        compare(a[i][j+2]+a[i+1][j]+a[i+1][j+1]+a[i+1][j+2]); //case7
        compare(a[i][j+1]+a[i+1][j+1]+a[i+2][j]+a[i+2][j+1]); //case8
        compare(a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+2]); //case9
        compare(a[i][j]+a[i][j+1]+a[i+1][j]+a[i+2][j]); //case10
        compare(a[i][j]+a[i+1][j]+a[i+1][j+1]+a[i+1][j+2]); //case11
        compare(a[i][j]+a[i+1][j]+a[i+1][j+1]+a[i+2][j+1]); //case12
        compare(a[i][j+1]+a[i][j+2]+a[i+1][j]+a[i+1][j+1]); //case13
        compare(a[i][j+1]+a[i+1][j]+a[i+1][j+1]+a[i+2][j]); //case14
        compare(a[i][j]+a[i][j+1]+a[i+1][j+1]+a[i+1][j+2]); //case15
        compare(a[i][j+1]+a[i+1][j]+a[i+1][j+1]+a[i+1][j+2]); //case16
        compare(a[i][j]+a[i+1][j]+a[i+1][j+1]+a[i+2][j]); //case17
        compare(a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+1]); //case18
        compare(a[i][j+1]+a[i+1][j]+a[i+1][j+1]+a[i+2][j+1]); //case19
    }

    private static void compare(int value){
        result = Math.max(result, value);
    }
}