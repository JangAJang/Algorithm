import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static final Stack<Character> operator = new Stack<>();

    public static void main(String[] args) throws IOException{
        String input = br.readLine();
        for(int index = 0; index < input.length(); index++){
            char each = input.charAt(index);
            if(each >='A' && 'Z' >= each){
                sb.append(each);
                continue;
            }
            if(each == '('){
                operator.push(each);
                continue;
            }
            if(each == ')'){
                while(!operator.isEmpty()){
                    if(operator.peek() == '('){
                        operator.pop();
                        break;
                    }
                    sb.append(operator.pop());
                }
                continue;
            }
            while(!operator.isEmpty() && priority(each) <= priority(operator.peek())) sb.append(operator.pop());
            operator.push(each);
        }
        while(!operator.isEmpty()){
            sb.append(operator.pop());
        }
        System.out.println(sb.toString());
    }

    static int priority(char temp) {
        if(temp == '(') return 0;
        else if(temp == '+' || temp == '-') return 1;
        else return 2;
    }
}