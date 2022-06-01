import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    static boolean checkNumber(int row, int col, int size){
        int num = arr[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(num != arr[i][j]) return false;
            }
        }
        return true;
    }

    static void cutting(int row, int col, int size){
        if(checkNumber(row, col, size)){
            sb.append(arr[row][col]);
            return;
        }
        sb.append("(");
        cutting(row, col, size/2);
        cutting(row, col+size/2, size/2);
        cutting(row+size/2, col, size/2);
        cutting(row+size/2, col+size/2, size/2);
        sb.append(")");
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        arr = new int[t][t];
        for(int i=0; i<t; i++){
            String s = br.readLine();
            for(int j=0; j<t; j++){
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        cutting(0, 0, t);
        System.out.println(sb);
    }
}
