import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int time = 0;
        for(int i=0; i<S.length(); i++){
            time += Time(S.charAt(i));
        }
        System.out.println(time);
    }
    static int Time(char c){
        if(c>='A' && c<='C') return 3;
        if(c>='D' && c<='F') return 4;
        if(c>='G' && c<='I') return 5;
        if(c>='J' && c<='L') return 6;
        if(c>='M' && c<='O') return 7;
        if(c>='P' && c<='S') return 8;
        if(c>='T' && c<='V') return 9;
        if(c>='W' && c<='Z') return 10;
        else return 0;
    }
}
