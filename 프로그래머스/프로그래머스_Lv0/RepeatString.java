import java.util.*;

public class RepeatString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            sb.append(str);
        }
        System.out.println(sb.toString());
    }
}
