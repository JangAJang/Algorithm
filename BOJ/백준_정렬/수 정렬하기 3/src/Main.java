import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[10000];
        for(int i=0; i<T; i++){
            int a = Integer.parseInt(br.readLine());
            arr[a-1]++;
        }
        for(int i=0; i<10000; i++){
            for(int j=0; j<arr[i]; j++){
                bw.write(i+1+"\n");
            }
        }
        bw.flush();
    }
}
