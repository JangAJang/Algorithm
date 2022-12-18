public class OverlappingLine {
    // lv0. 겹치는 선분의 길이
    class Solution {
        public int solution(int[][] lines) {
            int formerPoint = lines[0][0], ladderPoint = lines[0][1];
            int total = 0;
            for(int[] line : lines){
                formerPoint = Math.min(line[0], formerPoint);
                ladderPoint = Math.max(line[1], ladderPoint);
                total += line[1] - line[0];
            }
            return total - (ladderPoint - formerPoint);
        }
    }
}
