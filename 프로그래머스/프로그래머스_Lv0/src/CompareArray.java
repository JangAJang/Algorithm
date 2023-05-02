import java.util.*;
import java.util.stream.*;

public class CompareArray {
    class Solution {
        public int solution(int[] arr1, int[] arr2) {
            int lengthDiffer =  arr1.length - arr2.length;
            if(lengthDiffer != 0){
                return lengthDiffer/ Math.abs(lengthDiffer);
            }
            int arr1Sum = Arrays.stream(arr1).sum();
            int arr2Sum = Arrays.stream(arr2).sum();
            int sumDiffer = arr1Sum - arr2Sum;
            if(sumDiffer != 0){
                return sumDiffer/Math.abs(sumDiffer);
            }
            return 0;
        }
    }
}
