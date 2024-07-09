package DailyQuestions;

public class AverageWaitingTime {

    public double averageWaitingTime(int[][] customers) {
        double currentTime = 0;
        double addedTime = 0;

        for(int[] customer : customers) {
            if(currentTime < customer[0]) {
                currentTime = customer[0];
            }
            currentTime += customer[1];
            addedTime += currentTime - customer[0];
        }

        return addedTime / customers.length;
    }
}
