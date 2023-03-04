import java.io.*;
import java.util.*;

public class Main {

    private static final Deque<Integer> queue = new ArrayDeque<>();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            String command = br.readLine();
            if(command.contains("push")) push(command.split(" ")[1]);
            if(command.equals("front")) printFront();
            if(command.equals("back"))printBack();
            if(command.equals("size")) printSize();
            if(command.equals("empty")) printEmpty();
            if(command.equals("pop")) printPop();
        }
    }

    private static void printPop() {
        if(queue.isEmpty()){
            System.out.println(-1);
            return;
        }
        System.out.println(queue.pop());
    }

    private static void printEmpty() {
        if(queue.isEmpty()){
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    private static void printSize() {
        System.out.println(queue.size());
    }

    private static void printBack() {
        if(queue.isEmpty()){
            System.out.println(-1);
            return;
        }
        System.out.println(queue.getLast());
    }

    private static void printFront() {
        if(queue.isEmpty()){
            System.out.println(-1);
            return;
        }
        System.out.println(queue.getFirst());
    }

    private static void push(String s) {
        queue.addLast(Integer.parseInt(s));
    }
}