import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) { String a = sc.nextLine();
            if(a.equals(".")) break;
            String[] input = a.split("");
            Stack<String> stack = new Stack<>();
            for (String str : input) {
                if (str.equals("(") || str.equals("[")) stack.push(str);
                else if (str.equals(")") && !stack.isEmpty() && stack.peek().equals("(")) stack.pop();
                else if (str.equals("]") && !stack.isEmpty() && stack.peek().equals("[")) stack.pop();
                else if (str.equals(")") || str.equals("]")) stack.push(str);
            }
            if (stack.empty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
