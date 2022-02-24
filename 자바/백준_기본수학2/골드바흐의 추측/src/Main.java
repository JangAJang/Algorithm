import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int x=0; x<T; x++) {
            int Case = Integer.parseInt(br.readLine());
            int a = 0, b = 0;
            for (int i = 2; i <= Case / 2; i++) {
                if (Prime(i) && Prime(Case - i)) {
                    if (a == 0 & b == 0) a = i;
                    b = Case - i;
                    if (Math.abs(a - b) > Math.abs(Case - i - i)) a = i;
                    b = Case - i;
                }
            }
            System.out.println(a+" "+b);
        }
    }
    static boolean Prime(int x){
        boolean check = true;
        if(x==2) return true;
        else{for(int i=2; i<=Math.sqrt(x)+1; i++) {
            if (x % i == 0) check = false;
            }
        }
        return check;
    }
}
