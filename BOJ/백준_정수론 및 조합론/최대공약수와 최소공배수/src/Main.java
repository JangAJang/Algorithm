import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int min = Math.min(a, b);
        int gcd = 0;
        for(int i=1; i<=min; i++){
            if(a%i == 0 && b%i == 0) gcd=i;
        }
        System.out.println(gcd);
        System.out.println(a*(b/gcd));
    }
}
