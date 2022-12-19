import java.util.ArrayList;
import java.util.List;

public class Parallel {
    // lv0. 평행
    class Solution {

        private final List<Double> inclinations = new ArrayList<>();

        public int solution(int[][] dots) {
            for(int firstPoint = 0; firstPoint < dots.length; firstPoint++){
                if(isLineParallel(dots, firstPoint)) return 1;
            }
            return 0;
        }

        private boolean isLineParallel(int[][] dots, int firstPoint){
            for(int secondPoint = firstPoint+1; secondPoint < dots.length; secondPoint++){
                double inclination = makeSlope(dots[firstPoint], dots[secondPoint]);
                if(inclinations.contains(inclination)) return true;
                inclinations.add(inclination);
            }
            return false;
        }

        private double makeSlope(int[] dot1, int[] dot2){
            return (double)(dot1[1] - dot2[1])/(double)(dot1[0] - dot2[0]);
        }
    }
}
