public class CalculateConsideringArrayLength {
    class Solution {
        public int[] solution(int[] arr, int n) {
            int changeIndex = Math.abs(arr.length%2 - 1);
            for(int index = 0; index < arr.length; index +=2) {
                arr[index+changeIndex] +=n;
            }
            return arr;
        }
    }
}
