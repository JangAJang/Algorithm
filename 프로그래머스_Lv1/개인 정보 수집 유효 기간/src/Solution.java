import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    private static final int DAYS_PER_MONTH = 28;
    private static final int MONTHS_PER_YEARS = 12;
    private static final HashMap<String, Integer> privacyType = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        addTerms(terms);
        return checkPrivacies(privacies, today);
    }

    private void addTerms(String[] terms){
        for(int index = 0; index < terms.length; index++){
            String[] termEach = terms[index].split(" ");
            privacyType.put(termEach[0], Integer.parseInt(termEach[1]));
        }
    }

    private int[] checkPrivacies(String[] privacies, String today){
        int todayDays = getDays(today.split("\\."));
        List<Integer> indexes = new ArrayList<>();
        for(int index = 0; index < privacies.length; index++){
            if(getDays(calculateTerms(privacies[index])) <= todayDays) indexes.add(index+1);
        }
        return indexes.stream().mapToInt(Integer::intValue).toArray();
    }

    private String[] calculateTerms(String privacy){
        String[] privacySeperated = privacy.split(" ");
        String[] date = privacySeperated[0].split("\\.");
        date[1] = Integer.toString(Integer.parseInt(date[1]) + privacyType.get(privacySeperated[1]));
        return date;
    }

    private int getDays(String[] date){
        int months = MONTHS_PER_YEARS * Integer.parseInt(date[0]) + Integer.parseInt(date[1]);
        return months * DAYS_PER_MONTH + Integer.parseInt(date[2]);
    }
}