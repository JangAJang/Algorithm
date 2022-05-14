
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int X;
    static int Y;
    static int W;
    static int H;
    static int R;

    static boolean IsInCircle1(int x, int y){
        if((x-X) * (x-X) + (y-Y-R)*(y-Y-R)<=R*R) return true;
        else return false;
    }

    static boolean IsInCircle2(int x, int y){
        if((x-X-W) * (x-X-W) + (y-Y-R)*(y-Y-R)<=R*R) return true;
        else return false;
    }

    static boolean IsInRec(int x, int y){
        if( x>= X && x<=(X+W)){
            if(y>=Y && y<= (Y+H)) return true;
            else return false;
        }
        else return false;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        R = H/2;
        int p = Integer.parseInt(st.nextToken());
        int count=0;
        for(int i=0; i<p; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(IsInCircle1(x, y) || IsInCircle2(x, y) || IsInRec(x, y))count++;
        }
        System.out.println(count);
    }
}
