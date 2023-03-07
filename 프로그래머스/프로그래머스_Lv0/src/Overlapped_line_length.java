import java.util.Arrays;

public class Overlapped_line_length {
    // lv0. 겹치는 선분의 길이
    class Solution {
        public int solution(int[][] lines) {
            int[] array = new int[201];
            for(int[] line : lines){
                for(int start = line[0]+100; start < line[1]+100; start++){
                    array[start]++;
                }
            }
            return (int)Arrays.stream(array).filter(s -> s > 1).count();
        }
    }
}
