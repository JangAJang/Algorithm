import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int h = s.nextInt(), m=s.nextInt();
        int add=s.nextInt();
        m += add;
        h = h+ m/60;
        m = m%60;
        if(h >= 24) h-=24;
        System.out.print(h);
        System.out.print(' ');
        System.out.println(m);
    }
}
