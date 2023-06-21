import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangeStringAndSearch {
    class Solution {
        public int solution(String myString, String pat) {
            List<Integer> list = new ArrayList<>();
            char[] arr = myString.toCharArray();
            System.out.println(Arrays.toString(arr));
            int count;
            for(int index = 0; index < arr.length; index++) {
                arr[index] = flipChar(arr[index]);
            }
            for(int start : list) {
                count = 0;
                for(int index = start; index < pat.length(); index++) {
                    if( arr[index] == pat.charAt(index - start)) count++;
                }
                if( count == pat.length()) return 1;
            }
            return 0;
        }

        private char flipChar(char c){
            if(c == 'A') return 'B';
            return 'A';
        }
    }
}
