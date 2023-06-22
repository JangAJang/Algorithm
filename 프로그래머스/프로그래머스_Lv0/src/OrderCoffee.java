import java.util.*;

public class OrderCoffee {
    public class Solution{
        public int solution(String[] order) {
            return Arrays.stream(order).mapToInt(i -> mapToPrice(i)).sum();
        }

        private int mapToPrice(String menu) {
            if(menu.contains("cafelatte")) {
                return 5000;
            }
            return 4500;
        }
    }
}
