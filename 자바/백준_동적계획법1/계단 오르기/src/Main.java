import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        int[] arr = new int [301];
        int[] score = new int[301];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        score[1] = arr[1];
        score[2] = arr[1]+arr[2];
        score[3] = Math.max(arr[1], arr[2]) + arr[3];
        for(int i=4; i<=N; i++){
            score[i] = Math.max(score[i-3]+arr[i-1], score[i-2])+arr[i];
        }
        System.out.println(score[N]);
    }
}