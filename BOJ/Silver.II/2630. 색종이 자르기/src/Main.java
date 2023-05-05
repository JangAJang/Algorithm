import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int oneSquare = 0;
    private static int zeroSquare = 0;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[][] field =  new int[n][n];
        for(int x = 0; x < n; x++){
            field[x] = Arrays.copyOf(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray(), n);
        }
        countSquare(field, new int[]{0, 0}, n);
        System.out.println(zeroSquare);
        System.out.println(oneSquare);
    }

    private static void countSquare(int[][] field, int[] start, int length) {
        int number = field[start[0]][start[1]];
        for(int x = start[0]; x < start[0] + length; x++){
            for(int y = start[1]; y < start[1] + length; y++){
                if(field[x][y] != number) {
                    countSquare(field, start, length/2);
                    countSquare(field, new int[]{start[0] , start[1] + length/2}, length/2);
                    countSquare(field, new int[]{start[0] + length/2 , start[1]}, length/2);
                    countSquare(field, new int[]{start[0] + length/2 , start[1] + length/2}, length/2);
                    return;
                }
            }
        }
        if(number == 1){
            oneSquare++;
            return;
        }
        zeroSquare++;
    }
}