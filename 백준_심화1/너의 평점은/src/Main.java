import java.io.*;
import java.util.*;

public class Main {

    private static int count = 20;
    private static int pass = 0;
    private static double average = 0;
    private static double totalTime = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int index = 0; index < count; index++){
            String[] data = br.readLine().split(" ");
            if(data[2].equals("P")){
                continue;
            }
            double time = Double.parseDouble(data[1]);
            double score = calculateScore(data[2]);
            totalTime += time;
            average += time * score;
        }
        System.out.println(String.format("%.6f",average / totalTime));
    }

    private static double calculateScore(String score){
        if(score.equals("A+")) return 4.5;
        if(score.equals("A0")) return 4.0;
        if(score.equals("B+")) return 3.5;
        if(score.equals("B0")) return 3.0;
        if(score.equals("C+")) return 2.5;
        if(score.equals("C0")) return 2.0;
        if(score.equals("D+")) return 1.5;
        if(score.equals("D0")) return 1.0;
        return 0.0;
    }
}