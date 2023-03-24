import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] sudoku;
    private static List<int[]> zeroIndex;
    public static void main(String[] args) throws IOException{
        sudoku = new int[9][9];
        zeroIndex = new ArrayList<>();
        for(int x = 0; x < 9; x++){
            sudoku[x] = Arrays.copyOf(Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt).toArray(), 9);
            for(int y = 0; y < 9; y++){
                if(sudoku[x][y] == 0) zeroIndex.add(new int[]{x, y});
            }
        }
        backTrackSudoku(0);
    }

    private static void backTrackSudoku(int zeroCleared){
        if(zeroCleared == zeroIndex.size()){
            for(int x = 0; x < 9; x++){
                for(int y= 0; y < 9; y++){
                    System.out.print(sudoku[x][y]);
                }
                System.out.println();
            }
            System.exit(0);
        }
        int x = zeroIndex.get(zeroCleared)[0];
        int y = zeroIndex.get(zeroCleared)[1];
        boolean[] alreadyIn = new boolean[10];
        for(int index = 0; index < 9; index++){
            if(sudoku[x][index] != 0) alreadyIn[sudoku[x][index]] = true;
            if(sudoku[index][y] != 0) alreadyIn[sudoku[index][y]] = true;
        }
        int squareX = (x/3)*3;
        int squareY = (y/3)*3;
        for(int startX = squareX; startX < squareX+3; startX++){
            for(int startY = squareY; startY < squareY + 3 ; startY++){
                if(sudoku[startX][startY] != 0) alreadyIn[sudoku[startX][startY]] = true;
            }
        }
        for(int value = 1; value <=9; value ++){
            if(!alreadyIn[value]){
                sudoku[x][y] = value;
                backTrackSudoku(zeroCleared+1);
                sudoku[x][y] = 0;
            }
        }
    }
}