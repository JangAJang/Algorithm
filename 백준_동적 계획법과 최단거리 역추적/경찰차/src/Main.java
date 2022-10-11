import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int T;
    public static int count;
    public static int[][] dp = new int[1002][1002];
    public static int[][] eventPosition = new int[1002][2];

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         T = Integer.parseInt(br.readLine());
         count = Integer.parseInt(br.readLine());
         for(int i=1; i<=count; i++){
             StringTokenizer st = new StringTokenizer(br.readLine(), " ");
             eventPosition[i][0] = Integer.parseInt(st.nextToken());
             eventPosition[i][1] = Integer.parseInt(st.nextToken());
         }
         StringBuilder sb = new StringBuilder();
         sb.append(getResult(1, 0, 0)).append("\n");
         int firstCar = 0, secondCar = 0;
         for(int i=1; i<= count; i++){
             int firstCarDistance = distance(1, firstCar, i);
             if(dp[firstCar][secondCar] - firstCarDistance == dp[i][secondCar]){
                 firstCar = i;
                 sb.append(1).append("\n");
             }
             else{
                 secondCar = i;
                 sb.append(2).append("\n");
             }
         }
        System.out.println(sb);
    }

    public static int getResult(int eventIdx, int firstCar, int secondCar){
        if(eventIdx > count) return 0;
        if(dp[firstCar][secondCar] != 0) return dp[firstCar][secondCar];
        int firstCartMove = getResult(eventIdx+1, eventIdx, secondCar) + distance(1, firstCar, eventIdx);
        int secondCarMove = getResult(eventIdx+1, firstCar, eventIdx) + distance(2, secondCar, eventIdx);
        return dp[firstCar][secondCar] = Math.min(firstCartMove, secondCarMove);
    }

    public static int distance(int carNumber, int startIdx, int endIdx){
        int[] startLocation = getStartLocation(carNumber, startIdx);
        return Math.abs(startLocation[0] - eventPosition[endIdx][0]) + Math.abs(startLocation[1] - eventPosition[endIdx][1]);
    }

    public static int[] getStartLocation(int carNumber, int index){
        if(index == 0){
            if(carNumber == 1) return new int[]{1, 1};
            return new int[]{T, T};
        }
        return eventPosition[index];

    }
}
