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
            if(N==0) break;
            String[] arr = new String[N];
            for(int i=0; i<N; i++){
                arr[i] = br.readLine();
            }
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String t1 = o1.toLowerCase();
                    String t2 = o2.toLowerCase();
                    int length = Math.min(t1.length(), t2.length());
                    for(int i=0; i<length; i++){
                        if(t1.charAt(i) > t2.charAt(i)) return 1;
                        else if(t1.charAt(i) < t2.charAt(i)) return -1;
                    }
                    return 0;
                }
            });
            System.out.println(arr[0]);
        }
    }
}
