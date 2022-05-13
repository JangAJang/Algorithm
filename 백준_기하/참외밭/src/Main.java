import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] arr = new int[6][2];
        int max_width = 0;
        int max_height = 0;
        int max_width_index = 0;
        int max_height_index = 0;
        int min_height;
        int min_width;
        int area = 0;
        for(int i=0;i<6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<6; i++){
            if(arr[i][0] == 1 || arr[i][0] == 2){
                max_width = Math.max(max_width, arr[i][1]);
                if(max_width == arr[i][1]) max_width_index=i;
            }
            else if(arr[i][0] == 3 || arr[i][0] == 4){
                max_height = Math.max(max_height, arr[i][1]);
                if(max_height==arr[i][1]) max_height_index = i;
            }
        }
        area = max_width * max_height;
        min_height = Math.abs(arr[(max_width_index+5)%6][1] - arr[(max_width_index+1)%6][1]);
        min_width = Math.abs(arr[(max_height_index+5)%6][1] - arr[(max_height_index+1)%6][1]);
        area = (area-(min_height * min_width))*count;
        System.out.println(area);
    }
}
