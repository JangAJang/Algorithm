import java.io.BufferedReader;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    static int[][] arr = new int[20][20];
    static int N;
    static boolean[] check = new boolean[20];
    static int result = 1000000;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int index, int n){
        if(n == (N)/2){
            int start=0, link=0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(check[i]&&check[j]) start+= (arr[i][j]);
                    if(!check[i]&&!check[j]) link +=(arr[i][j]);
                }
            }
            result = Math.min(Math.abs(start-link), result);
            return ;
        }
        for(int i=index; i<N; i++){
            if(!check[i]){
                check[i] = true;
                dfs(index+1, n+1);
                check[i] = false;
            }
        }
    }
}