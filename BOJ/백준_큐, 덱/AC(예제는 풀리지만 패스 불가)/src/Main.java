import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException{
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            doTask();
        }
    }

    public static void doTask()throws IOException{
        String command = br.readLine();
        boolean isReversed = false;
        int count = Integer.parseInt(br.readLine());
        Deque<Integer> arr = new ArrayDeque<>();
        String[] strings = br.readLine().split(",");
        for(int i=0; i<count; i++){
            if(strings[i].contains("[")) strings[i] = strings[i].replace("[", "");
            if(strings[i].contains("]")) strings[i] = strings[i].replace("]", "");
            arr.add(Integer.parseInt(strings[i]));
        }
        for(int i=0; i<command.length(); i++){
            if(arr.size() == 0){
                System.out.println("error");
                return;
            }
            if(command.charAt(i) == 'R'){
                isReversed = !isReversed;
            }
            else if(command.charAt(i) == 'D'){
                if(isReversed) arr.pollLast();
                else arr.pollFirst();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(isReversed){
            if(!arr.isEmpty())sb.append(Integer.toString(arr.pollLast()));
            else {
                System.out.println("error");
                return;
            }
            while(!arr.isEmpty()){
                sb.append(",");
                sb.append(Integer.toString(arr.pollLast()));
            }
        }
        else{
            if(!arr.isEmpty())sb.append(Integer.toString(arr.pollFirst()));
            while(!arr.isEmpty()){
                sb.append(",");
                sb.append(Integer.toString(arr.pollFirst()));
            }

        }
        sb.append("]");
        System.out.println(sb);
    }
}
