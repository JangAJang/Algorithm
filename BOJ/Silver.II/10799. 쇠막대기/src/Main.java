// Silver2. 10799. 쇠막대기
import java.io.*;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String input = br.readLine();
        Deque<Character> deque = new ArrayDeque<>();
        String[] splitByLazer = input.split("\\(\\)");
        int[] size = new int[splitByLazer.length];
        int answer = 0;
        for(int part = 0; part < splitByLazer.length; part++) {
            for(int index = 0; index < splitByLazer[part].length(); index++) {
                if(splitByLazer[part].charAt(index) == '(') {
                    deque.offer('(');
                    continue;
                }
                deque.pop();
                size[part]++;
            }
            size[part] += deque.size();
            answer += size[part];
        }
        System.out.println(answer);
    }
}