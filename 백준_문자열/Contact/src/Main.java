import java.io.*;

public class Main {

    private static final String regex = "(100+1+|01)+";

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String line = br.readLine();
            checkCase(line);
        }
    }

    private static void checkCase(String line){
        if(line.matches(regex)) System.out.println("YES");
        else System.out.println("NO");
    }
}