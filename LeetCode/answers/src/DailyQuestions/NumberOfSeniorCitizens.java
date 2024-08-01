package DailyQuestions;

import java.util.*;

public class NumberOfSeniorCitizens {

    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details)
            .map(each -> each.substring(11, 13))
            .filter(each -> Integer.parseInt(each) > 60)
            .count();
    }
}
