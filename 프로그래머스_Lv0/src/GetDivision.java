import java.util.ArrayList;
import java.util.List;

public class GetDivision {
    //lv0. 약수 구하기
    class Solution {

        List<Integer> numbers = new ArrayList<>();

        public int[] solution(int n) {
            addDivisions(n);
            return numbers.stream().sorted()
                    .mapToInt(Integer::intValue).toArray();
        }

        private void addDivisions(int n){
            for(int index = 1; index <= Math.sqrt(n); index++){
                if(n % index == 0){
                    addDivision(n, index);
                }
            }
        }

        private void addDivision(int n, int index){
            if(n%index == index){
                numbers.add(index);
                return;
            }
            numbers.add(index);
            numbers.add(n / index);
        }
    }
}
