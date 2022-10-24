import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int ASSIGNMENT_SENT = 28;
    static final int ALL_STUDENT = 31;

    static boolean[] checked;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        checkAssignmentNumber();
        printNotSentNumber();
    }

    private static void checkAssignmentNumber()throws IOException{
        checked = new boolean[ALL_STUDENT];
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<ASSIGNMENT_SENT; i++){
            checked[Integer.parseInt(br.readLine())] = true;
        }
    }

    private static void printNotSentNumber(){
        for(int i=1; i < ALL_STUDENT; i++){
            if(!checked[i]) System.out.println(i);
        }
    }
}