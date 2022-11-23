import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

    private static final Queue<Integer> buffer = new LinkedList<>();
    private static int bufferSize;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferSize = Integer.parseInt(bufferedReader.readLine());
        int nextData = Integer.parseInt(bufferedReader.readLine());
        while(nextData!= -1){
            addNumber(nextData);
            nextData = Integer.parseInt(bufferedReader.readLine());
        }
        System.out.println(makeResultStatement());
    }

    private static String makeResultStatement(){
        if(buffer.isEmpty()) return "empty";
        List<Integer> bufferSorted = buffer.stream().sorted().collect(Collectors.toList());
        return makeNumbersInLine(bufferSorted);
    }

    private static String makeNumbersInLine(List<Integer> bufferSorted){
        StringBuilder result = new StringBuilder();
        for(int number : bufferSorted){
            result.append(number).append(" ");
        }
        return result.toString();
    }

    private static void addNumber(int nextData){
        if(nextData == 0) {
            removeBuffer();
            return;
        }
        putData(nextData);
    }

    private static void removeBuffer(){
        if(buffer.isEmpty()) return;
        buffer.poll();
    }

    private static void putData(int nextData){
        if(buffer.size() >= bufferSize) return;
        buffer.add(nextData);
    }
}