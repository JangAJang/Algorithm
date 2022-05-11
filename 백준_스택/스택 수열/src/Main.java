import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        int last = 0;
        for(int i=0; i<n; i++){
            int add = Integer.parseInt(br.readLine());
            if(last > add && result.lastElement() < add){
                System.out.println("NO");
                return;
            }
            if(add > last){
                for(int j = last + 1; j <= add; j++){
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                int tmp = stack.pop();
                sb.append('-').append('\n');
                result.push(tmp);
                last = add;
            }
            else if(add< last){
                while(stack.lastElement() != add){
                    int tmp = stack.pop();
                    sb.append('-').append('\n');
                }
                result.push(add);
            }
        }
        System.out.println(sb);
    }
}

