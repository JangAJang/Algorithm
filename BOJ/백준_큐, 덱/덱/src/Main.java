import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();
        ArrayDeque<Integer> deck = new ArrayDeque<Integer>();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "push_front" :
                    deck.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    deck.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    if(deck.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deck.poll()).append("\n");
                    break;
                case "pop_back" :
                    if(deck.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deck.pop()).append("\n");
                    break;
                case "size" :
                    sb.append(deck.size()).append("\n");
                    break;
                case "empty" :
                    if(deck.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front" :
                    if(deck.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deck.getFirst()).append("\n");
                    break;
                case "back" :
                    if(deck.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deck.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
