import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int subin = Integer.parseInt(st.nextToken());
        int brother = Integer.parseInt(st.nextToken());
        int result = 100000;
        boolean[] visited = new boolean[100001];
        Queue<Place> queue = new LinkedList<>();
        queue.add(new Place(subin, 0));
        visited[subin] = true;
        while(!queue.isEmpty()){
            Place now = queue.poll();
            if(now.location == brother) result = Math.min(result, now.count);
            else{
                int[] arr = new int[3];
                arr[0] = now.location + 1;
                arr[1] = now.location - 1;
                arr[2] = now.location * 2;
                for(int i=0; i<3; i++){
                    if(arr[i] < 0 || arr[i] > 100000) continue;
                    else if(visited[arr[i]]) continue;
                    queue.add(new Place(arr[i], now.count+1));
                    visited[arr[i]] = true;
                }
            }
        }
        System.out.println(result);
    }

    public static class Place{
        int location;
        int count;

        public Place(int location, int count){
            this.location = location;
            this.count = count;
        }
    }
}
