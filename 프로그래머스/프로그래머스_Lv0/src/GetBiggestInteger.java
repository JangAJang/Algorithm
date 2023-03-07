public class GetBiggestInteger {
    // lv0. 가장 큰 수 찾기
    class Solution {
        public int[] solution(int[] array) {
            int max = 0;
            for(int index = 0; index < array.length; index++){
                if(array[index] > array[max]) max = index;
            }
            return new int[]{array[max], max};
        }
    }
}
