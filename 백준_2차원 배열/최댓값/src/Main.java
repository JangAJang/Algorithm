import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MAX_WIDTH = 9;
    static final int MAX_HEIGHT = 9;

    static BufferedReader br;
    static int value, width, height;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        value = 0;
        width = 0;
        height = 0;
        getLargestFromRadix();
    }

    private static void getLargestFromRadix()throws IOException{
        for(int i=0; i<MAX_WIDTH; i++){
            getLargestFromArray(i);
        }
        System.out.println(value);
        System.out.println(width + " " + height);
    }

    private static void getLargestFromArray(int i)throws IOException{
        String[] nums = br.readLine().split(" ");
        for(int j=0; j<MAX_HEIGHT; j++){
            int x = Integer.parseInt(nums[j]);
            setNumber(x, new int[]{i, j});
        }
    }

    private static void setNumber(int x, int[] location){
        if(x >= value){
            value = x;
            width = location[0]+1;
            height = location[1]+1;
        }
    }
}