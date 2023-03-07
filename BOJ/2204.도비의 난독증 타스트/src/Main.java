import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) return;
            String[] arr = new String[N];
            for(int i=0; i<N; i++){
                arr[i] = br.readLine();
            }
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.toLowerCase().compareTo(o2.toLowerCase());
                }
            });
            System.out.println(arr[0]);
        }
    }
}
