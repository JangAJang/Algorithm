import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            int count=0;
            for(int x=n+1; x<=2*n; x++) {
                boolean check = true;
                if (x == 1) check = false;
                else if (x == 2) check = true;
                else for (int i = 2; i <= Math.sqrt(x)+1; i++) {
                        if (x % i == 0) {
                            check = false;
                            break;
                        }
                    }
                if(check) count++;
            }
            System.out.println(count);
        }
    }
}
