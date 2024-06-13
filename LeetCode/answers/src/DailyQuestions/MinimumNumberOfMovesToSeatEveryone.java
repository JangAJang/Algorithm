package DailyQuestions;

import java.util.*;

public class MinimumNumberOfMovesToSeatEveryone {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int answer = 0;

        for(int index = 0; index < seats.length; index++) {
            answer += Math.abs(seats[index] - students[index]);
        }

        return answer;
    }
}
