import java.util.Scanner;

public class Main {

    public static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=1; i<=C; i++){
            TwoPoint(arr, i);
        }
        System.out.println(count+1);
    }

    public static void TwoPoint(int[] arr, int sum){
        int start = 0, end = 0;
        int total = 0;
        while(start <arr.length && end < arr.length){
            if(total  == sum) count++;
            if(total < sum) total += arr[end++];
            else total -= arr[start++];
        }
    }
}
