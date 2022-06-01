import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int OneCalculation()throws IOException{
        String command = br.readLine();
        int numbers = Integer.parseInt(br.readLine());
        String sentence = br.readLine().replace("[", "").replace("]", "");
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(sentence, ",");
        for(int i=0; i<numbers; i++){
            deque.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<command.length(); i++){
            if(command.charAt(i) == 'R'){
                R(deque);
            }
            else if(command.charAt(i) == 'D'){
                if(deque.isEmpty()){
                    System.out.println("error");
                    return 0;
                }
                else{
                    D(deque);
                }
            }
        }
        System.out.println(deque.toString());
        return 0;
    }

    static void R(Deque<Integer> deque){
        Deque<Integer> tmp = new ArrayDeque<>();
        int t = deque.size();
        for(int i=0; i<t; i++){
            tmp.add(deque.pollLast());
        }
        deque.clear();
        for(int i=0; i<t; i++){
            deque.add(tmp.pollFirst());
        }
    }

    static void D(Deque<Integer> deque){
        deque.removeFirst();
    }

    public static void main(String[] args)throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            OneCalculation();
        }
    }
}
