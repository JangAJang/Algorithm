package DailyQuestions;

public class DesignAStackWithIncrementOperation {

    class CustomStack {

        private Map<Integer, Integer> map;
        private int max;

        public CustomStack(int maxSize) {
            max = maxSize;
            map = new HashMap<>();
        }

        public void push(int x) {
            if(map.keySet().size() == max) return;

            if(map.keySet().isEmpty()) {
                map.put(0, x);
                return;
            }

            map.put(map.keySet().size(), x);
        }

        public int pop() {
            if(map.keySet().isEmpty()) return -1;
            final int value = map.get(map.keySet().size()-1);
            map.remove(map.keySet().size()-1);
            return value;
        }

        public void increment(int k, int val) {
            if(map.keySet().isEmpty()) return;

            for(int each : map.keySet()) {
                if(each < k) map.put(each, map.get(each) + val);
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
}
