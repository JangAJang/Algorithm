public class MakeSecondary {
    // lv0. 2차원으로 만들기
    class Solution {
        public int[][] solution(int[] num_list, int n) {
            int[][] newList = new int[num_list.length / n][n];
            for(int index = 0; index < num_list.length; index ++){
                newList[index/n][index%n] = num_list[index];
            }
            return newList;
        }
    }
}
