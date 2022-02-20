import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for(int i=1; i<10; i++){
            System.out.println(x+" * "+i+" = "+(x*i));
        }
    }
}
