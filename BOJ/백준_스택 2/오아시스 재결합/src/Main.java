import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{

    public static class Point{
         int height;
         int count;

        public Point(int height, int count){
            this.height = height;
            this.count = count;
        }

        public void addCount(){
            count++;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long result = 0;
        Stack<Point> points = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!points.isEmpty() && points.peek().height < arr[i]) {
                result+= points.pop().count;
            }

            if(points.isEmpty()) {
                points.push(new Point(arr[i], 1));
            }else {
                if(points.peek().height > arr[i]) {
                    points.push(new Point(arr[i], 1));
                    result++;
                } else {
                    result += points.peek().count;
                    points.peek().addCount();
                    if(points.size()>1) {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}