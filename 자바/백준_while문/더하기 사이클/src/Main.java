import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count=0;
        int result=N;
        do{
            N = ((N/10 + N%10))%10 + (N%10)*10;
            count++;
        } while(result != N);
        System.out.println(count);
    }
}