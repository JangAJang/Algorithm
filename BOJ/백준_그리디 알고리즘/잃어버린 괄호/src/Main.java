import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        String[] str = tmp.split("\\-");
        int result = 0;
        for(int i=0; i<str.length; i++){
            String[] sum = str[i].split("\\+");
            int cal = 0;
            for(int j=0; j<sum.length; j++){
                cal += Integer.parseInt(sum[j]);
            }
            if(i==0) result = cal;
            else result -=cal;
        }
        System.out.println(result);
    }
}