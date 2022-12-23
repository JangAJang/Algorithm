import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException {
        int tasks = Integer.parseInt(br.readLine());
        while(tasks-- > 0){
            try{
                checkEachProcess();
            }catch (Exception e){
                System.out.println("error");
            }
        }
    }

    private static void checkEachProcess()throws IOException {
        String command = br.readLine();
        int number = Integer.parseInt(br.readLine());
        List<Integer> numberArray = Arrays.stream(br.readLine().replace("[", "").replace("]", "")
                .split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        for(int index = 0; index < command.length(); index++){
            changeWithCommand(command.charAt(index), numberArray);
        }
        System.out.println(numberArray.toString());
    }

    private static void changeWithCommand(char commandEach, List<Integer> numberArray){
        if(commandEach == 'R') Collections.reverse(numberArray);
        if(commandEach == 'D') numberArray.remove(0);
    }
}