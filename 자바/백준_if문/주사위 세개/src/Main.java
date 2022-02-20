import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int money = 0;
        if(a==b && b==c) money = 10000 + 1000*a;
        else if(a == b) money = 1000 + 100*a;
        else if(b==c) money = 1000 + 100*b;
        else if(c==a) money = 1000+100*c;
        else{
            if( a> b && a > c) money = a*100;
            if( b> a && b > c) money = b*100;
            if( c> b && c > a) money = c*100;
        }
        System.out.println(money);
    }
}
