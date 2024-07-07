package DailyQuestions;

public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int answer = 0;
        int lastBottles = 0;

        while (numBottles != 0) {
            answer += numBottles;
            int emptyBottles = numBottles + lastBottles;
            numBottles = emptyBottles / numExchange;
            lastBottles = emptyBottles % numExchange;
        }

        return answer;
    }
}
