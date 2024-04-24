package DailyQuestions;

public class Tribonacci {
    public int tribonacci(int n) {
        int[] arr = new int[Math.max(n+1, 3)];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        if(n < 3) return arr[n];
        for(int index = 3; index <= n; index++) {
            arr[index] = arr[index-1] + arr[index-2] + arr[index-3];
        }
        return arr[n];
    }
}
