import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());
        while(count-->0){
            try{
                System.out.println(modifyArray());
            }catch(NumberFormatException e){
                System.out.println("error");
            }
        }
    }

    private static String modifyArray()throws IOException{
        String commands = br.readLine();
        int length = Integer.parseInt(br.readLine());
        Deque<Integer> numbers = Arrays.stream(br.readLine()
                .replace("[", "").replace("]", "")
                .split(",")).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        return activateCommands(commands, numbers);
    }

    private static String activateCommands(String commands, Deque<Integer> numbers){
        for(int index = 0; index < commands.length(); index++){
            if(commands.charAt(index) == 'D' && numbers.isEmpty()) return "error";
            numbers = adjustEachCommand(commands.charAt(index), numbers);
        }
        return numbers.toString();
    }

    private static Deque<Integer> adjustEachCommand(char command, Deque<Integer> numbers){
        if(command == 'R'){
            List<Integer> flip = new ArrayList<>(numbers);
            Collections.reverse(flip);
            return new ArrayDeque<>(flip);
        }
        numbers.pollFirst();
        return numbers;
    }
}