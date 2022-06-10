import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(st.nextToken());
            if( x > list.get(list.size()-1)) list.add(x);
            else{
                int start = 0;
                int end = list.size()-1;
                while(start < end){
                    int mid = (start+end)/2;
                    if(list.get(mid) >= x) end = mid;
                    else start = mid+1;
                }
                list.set(end, x);
            }
        }
        System.out.println(list.size()-1);
    }
}
