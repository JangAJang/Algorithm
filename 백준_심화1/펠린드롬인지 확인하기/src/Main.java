import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int mid = word.length()/2;
        for(int index = 0; index < mid; index++){
            if(word.charAt(index) != word.charAt(word.length() - index - 1)){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}