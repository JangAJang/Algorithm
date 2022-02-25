import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println((int)Math.pow(2, N)-1);
        move(N, 1, 3, 2);
    }
    private static void move(int N, int start, int end, int sub) {
        if( N==1 ) { System.out.println(start + " " + end); return ; }
        move(N-1, start, sub, end);
        move(1, start, end, sub);
        move(N-1, sub, end, start);
    }
}

