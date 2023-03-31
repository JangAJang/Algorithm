import java.io.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long[] poweredNumber;
    private static long result;
    public static void main(String[] args) throws IOException{
        result = 0L;
        String[] bitInput = Long.toBinaryString(Long.parseLong(br.readLine())).split("");
        poweredNumber = powerThreeUntilBitInputLength(bitInput);
        IntStream.range(0, bitInput.length).forEach(i -> result += calculateBitInput(bitInput, i));
        System.out.println(result);
    }

    private static long[] powerThreeUntilBitInputLength(String[] bitInput){
        long[] resultNumbers = new long[bitInput.length];
        resultNumbers[0] = 1;
        IntStream.range(1, bitInput.length).forEach(i -> resultNumbers[i] = 3*resultNumbers[i-1]);
        return resultNumbers;
    }

    private static long calculateBitInput(String[] bitInput, int index){
        if(bitInput[index].equals("0")) return 0L;
        return poweredNumber[bitInput.length-1-index];
    }
}