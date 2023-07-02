public class ManipulateNumber2 {
    class Solution {
        public String solution(int[] numLog) {
            StringBuilder sb = new StringBuilder();
            for(int index = 0; index < numLog.length-1; index++) {
                sb.append(convertToChar(numLog[index], numLog[index+1]));
            }
            return sb.toString();
        }

        private char convertToChar(int before, int after) {
            if( before + 1 == after) return 'w';
            if( before - 1 == after) return 's';
            if( before + 10 == after) return 'd';
            return 'a';
        }
    }
}
