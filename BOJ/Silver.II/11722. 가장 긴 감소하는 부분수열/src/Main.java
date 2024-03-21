import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Silver2. 11722 가장 긴 감소하는 부분수열
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int index = 0; index < n; index++) {
            int value = Integer.parseInt(st.nextToken());
            if(value < list.get(list.size()-1)) {
                list.add(value);
                continue;
            }
            int start = 0;
            int end = list.size()-1;
            while(start < end) {
                int mid = (start+end)/2;
                if(list.get(mid) <= value) {
                    end = mid;
                    continue;
                }
                start = mid+1;
            }
            list.set(end, value);
        }
        System.out.println(list.size()-1);
    }
}