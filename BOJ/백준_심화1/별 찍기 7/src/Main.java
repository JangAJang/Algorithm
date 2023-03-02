import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int total = 2 * count - 1;
        for(int index = 1; index <= total; index++){
            int value = Math.min(index, 2*count - index);
            printStars(value, count);
        }
    }

    private static void printStars(int index, int count){
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < count - index; x++){
            sb.append(" ");
        }
        for(int x = 0; x < 2*index-1;x++){
            sb.append("*");
        }
        System.out.println(sb.toString());
    }
}