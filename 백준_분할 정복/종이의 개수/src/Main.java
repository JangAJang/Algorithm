import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int Zero=0;
    static int One=0;
    static int MinusOne=0;

    static void cutting(int row, int col, int size){
        if(isSameNumber(row, col, size)){
            if(arr[row][col] == 1) One++;
            else if(arr[row][col] == 0) Zero++;
            else MinusOne++;
            return;
        }
        else{
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    cutting( row + size/3*i, col + size/3*j, size/3);
                }
            }
        }
    }

    static boolean isSameNumber(int row, int col, int size){
        int check = arr[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(check != arr[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cutting(0, 0, n);
        System.out.println(MinusOne+"\n"+Zero+"\n"+One);
    }
}
