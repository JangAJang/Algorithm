import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int[][] arr;
    static int blue=0;
    static int white=0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new int[T][T];
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<T; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cutting(0, 0, T);
        System.out.println(white);
        System.out.println(blue);

    }

    public static void cutting(int row, int col, int size){
        if(whatColor(row, col, size)){
            if(arr[row][col] == 1) blue++;
            else white++;
            return;
        }
        cutting(row, col, size/2);
        cutting(row+size/2, col, size/2);
        cutting(row, col+size/2, size/2);
        cutting(row+size/2, col+size/2, size/2);
    }

    public static boolean whatColor(int row, int col, int size){
        int color = arr[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(arr[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }

}