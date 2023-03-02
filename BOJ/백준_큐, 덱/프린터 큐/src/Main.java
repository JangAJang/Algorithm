import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int task = 0; task <T; task++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            Deque<Integer> deck = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                deck.add(arr[i]);
            }
            int count = 0;
            Arrays.sort(arr);
            int location = m;
            for(int i=n-1; i>=0; i--){
                while(true){
                    if(arr[i] == deck.getFirst() && deck.size()>0){
                        count++;
                        deck.remove();
                        location = (location+n-1) % n;
                        break;
                    }
                    else if(arr[i] != deck.getFirst() && deck.size()>0){
                        int tmp = deck.poll();
                        deck.add(tmp);
                        location = (location+n-1) % n;
                    }
                }
                if(location == 0 &&(deck.isEmpty()||arr[i] == deck.getFirst())){
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
