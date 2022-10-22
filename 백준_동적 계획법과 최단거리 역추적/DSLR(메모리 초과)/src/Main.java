import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br;
    static List<String> list;

    static class Node{
        String numbers;
        String command;

        public Node(String numbers, String command){
            this.numbers = numbers;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int task = Integer.parseInt(br.readLine());
        while(task-->0){
            System.out.println(doTask());
        }
    }

    private static String doTask()throws IOException{
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String start = st.nextToken();
        String end = st.nextToken();
        return doBFS(start, end);
    }

    private static String doBFS(String start, String end){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, ""));
        list.add(start);
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(Integer.parseInt(now.numbers) == Integer.parseInt(end)){
                return now.command;
            }
            putCases(queue, now);
        }
        return "";
    }

    private static void putCases(Queue<Node> queue, Node now){
        doD(queue, now);
        doS(queue, now);
        doL(queue, now);
        doR(queue, now);
    }

    private static void doD(Queue<Node> queue, Node now){
        saveAfterD(calculateD(now), queue);
    }

    private static void doS(Queue<Node> queue, Node now){
        saveAfterS(calculateS(now), queue);
    }

    private static void doL(Queue<Node> queue, Node now){
        saveAfterL(calculateL(now), queue);
    }

    private static void doR(Queue<Node> queue, Node now){
        saveAfterR(calculateR(now), queue);
    }

    private static void saveAfterD(Node doD, Queue<Node> queue){
        if(!list.contains(doD.numbers)) queue.add(doD);
    }

    private static void saveAfterS(Node doS, Queue<Node> queue){
        if(!list.contains(doS.numbers)) queue.add(doS);
    }

    private static void saveAfterL(Node doL, Queue<Node> queue){
        if(!list.contains(doL.numbers)) queue.add(doL);
    }

    private static void saveAfterR(Node doR, Queue<Node> queue){
        if(!list.contains(doR.numbers)) queue.add(doR);
    }

    private static Node calculateD(Node now){
        String next = Integer.toString((Integer.parseInt(now.numbers)*2)%10000);
        return new Node(next, now.command.concat("D"));
    }

    private static Node calculateS(Node now){
        String next = Integer.toString((Integer.parseInt(now.numbers)-1+10000)%10000);
        return new Node(next, now.command.concat("S"));
    }

    private static Node calculateL(Node now){
        String[] next = now.numbers.split("");
        String first = next[0];
        String line = "";
        for(int i=0; i<next.length-1; i++){
            line = line.concat(next[i+1]);
        }
        return new Node(line.concat(first), now.command.concat("L"));
    }

    private static Node calculateR(Node now){
        String[] next = now.numbers.split("");
        String line = next[next.length-1];
        for(int i=0; i<next.length-1; i++){
            line = line.concat(next[i]);
        }
        return new Node(line, now.command.concat("R"));
    }
}