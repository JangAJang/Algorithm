import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int[][] radix1 = getRadix(flipStringArrayToInt(size));
        int[][] radix2 = getRadix(flipStringArrayToInt(size));
        getResult(radix1, radix2);
    }

    private static void getResult(int[][] radix1, int[][] radix2){
        for(int i=0; i< radix1.length; i++){
            for(int j=0; j<radix1[i].length; j++){
                System.out.print(radix1[i][j] + radix2[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static int[][] getRadix(int[] size){
        int[][] radix = new int[size[0]][size[1]];
        for(int i=0; i<size[0]; i++){
            try {
                radix[i] = getYNumbers();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return radix;
    }



    public static int[] getYNumbers()throws IOException {
        String[] numbers = br.readLine().split(" ");
        return flipStringArrayToInt(numbers);
    }

    private static int[] flipStringArrayToInt(String[] arr){
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(arr[i]);
        }
        return result;
    }
}