import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        System.out.println(Arrays.stream(Integer
                .toBinaryString(Integer.parseInt(br.readLine()))
                .split("")).filter(each -> each.equals("1")).count());
    }
}