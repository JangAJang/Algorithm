import java.util.Scanner;

public class Solution {
    //lv0. 직각삼각형 출력하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int count = 1; count <= n; count++){
            sb.append("*".repeat(count)).append("\n");
        }
        System.out.println(sb);
    }
}