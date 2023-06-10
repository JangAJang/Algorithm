public class CalculateEasySentence {
    class Solution {
        public int solution(String binomial) {
            String[] arr = binomial.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[2]);
            if(arr[1].equals("+")) return a + b;
            if(arr[1].equals("-")) return a - b;
            return a * b;
        }
    }
}
