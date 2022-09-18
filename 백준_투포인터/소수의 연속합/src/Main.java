import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        ArrayList<Integer> primes = getPrimes(x);
        int[] arr = new int[primes.size()+1];
        for(int i=0; i<primes.size(); i++){
            arr[i] = primes.get(i);
        }
        countPossibilities(arr, x);
    }

    public static ArrayList<Integer> getPrimes(int x){
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean[] prime = new boolean[x+1];
        for(int i=2; i*i<=x; i++){
            if(!prime[i]){
                for(int j=i*i;j<=x;j+=i){
                    prime[j] = true;
                }
            }
        }
        for(int i=2; i<=x; i++){
            if(!prime[i]) arrayList.add(i);
        }
        return arrayList;
    }

    public static void countPossibilities(int[] arr, int sum){
        int start = 0;
        int end = 0;
        int total = 0;
        int count = 0;
        while(start < arr.length && end < arr.length){
            if(total == sum) count++;
            if(total < sum) total += arr[end++];
            else total -= arr[start++];
        }
        System.out.println(count);
    }
}
