package DailyQuestions;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int index = 0; index < bills.length; index++) {
            if(bills[index] == 5) {
                five++;
                continue;
            }

            if(five == 0) return false;

            if(bills[index] == 10) {
                five--;
                ten++;
                continue;
            }

            if(ten > 0) {
                five--;
                ten--;
                continue;
            }

            if(five < 3) return false;

            five -= 3;
        }

        return true;
    }
}
