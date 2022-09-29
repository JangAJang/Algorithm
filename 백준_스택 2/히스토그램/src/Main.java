import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

    public static long[] histogram;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        histogram = new long[N];
        for(int i=0; i<N; i++){
            histogram[i] = Long.parseLong(br.readLine());
        }
        System.out.println(getArea(N));
    }

    public static long getArea(int len) {
        Stack<Integer> stack = new Stack<Integer>();
        long maxArea = 0;
        for(int i = 0; i < len; i++) {
            while((!stack.isEmpty()) && histogram[stack.peek()] >= histogram[i]) {
                long height = histogram[stack.pop()];
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            long height = histogram[stack.pop()];
            long width = stack.isEmpty() ? len: len - 1 - stack.peek();
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
    }
}