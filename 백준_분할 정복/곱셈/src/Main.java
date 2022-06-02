import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long multiply(long given_number, long multiplying_count, long remainder){
        if(multiplying_count == 1) return given_number % remainder;
        else if( multiplying_count % 2 == 0 ){
            long result = multiply(given_number, multiplying_count/2, remainder);
            return (result * result) % remainder;
        }
        else{
            long result = multiply(given_number, multiplying_count/2, remainder);
            return (((result * result)  %remainder)* given_number) % remainder;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long given_Number = Integer.parseInt(st.nextToken());
        long multiplying_count = Integer.parseInt(st.nextToken());
        long remainder = Integer.parseInt(st.nextToken());
        long result = multiply(given_Number, multiplying_count, remainder);
        System.out.println(result);
    }
}
