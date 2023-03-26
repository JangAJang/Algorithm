import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static int x;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        x = 0;
        while(count-- > 0){
            String command = br.readLine();
            if(command.equals("all")){
                addAll();
                continue;
            }
            if(command.equals("empty")){
                empty();
                continue;
            }
            String order = command.split(" ")[0];
            int number = Integer.parseInt(command.split(" ")[1]);
            if(order.equals("add")){
                addValue(number);
                continue;
            }
            if(order.equals("remove")){
                removeValue(number);
                continue;
            }
            if(order.equals("toggle")){
                toggleValue(number);
                continue;
            }
            if(order.equals("check")){
                checkValue(number);
            }
        }
    }

    private static void empty(){
        x = 0;
    }

    private static void addAll(){
        for(int index = 1; index <= 20; index++){
            addValue(index);
        }
    }

    private static void addValue(int number){
        x |= (1<<number);
    }

    private static void removeValue(int number){
        x = x & ~(1<<number);
    }

    private static void toggleValue(int number){
        x = x ^ (1<<number);
    }

    private static void checkValue(int number){
        if(Integer.toBinaryString(x).charAt(number-1) == '1') {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}