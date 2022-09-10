import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count = 0;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        while(testcases-->0){
            count = 0;
            String cases = br.readLine();
            System.out.println(isPalindrome(cases) + " " + count);
        }
    }

    public static int recursion(String cases, int l, int c){
        count++;
        if(l >= c) return 1;
        else if(cases.charAt(l) != cases.charAt(c)) return 0;
        else return recursion(cases, l+1, c-1);
    }

    public static int isPalindrome(String cases){
        return recursion(cases, 0, cases.length()-1);
    }
}
