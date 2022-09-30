import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            AC();
        }
    }

    public static void AC()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        int length = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
        boolean reversed = false;
        for(int i=0; i<length; i++){
            deque.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<command.length(); i++){
            if(command.charAt(i)=='R'){
                reversed = !reversed;
            }
            else if(command.charAt(i) == 'D'){
                if(deque.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                else {
                    if(reversed) deque.removeLast();
                    else deque.removeFirst();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if(reversed){
            sb.append(deque.pollLast());
            while(!deque.isEmpty()){
                sb.append(","+deque.pollLast());
            }
        }
        else{
            sb.append(deque.pollFirst());
            while(!deque.isEmpty()){
                sb.append(","+deque.pollFirst());
            }
        }
        sb.append(']');
        System.out.println(sb);

    }
}
