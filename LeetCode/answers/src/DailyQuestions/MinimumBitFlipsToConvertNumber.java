package DailyQuestions;

public class MinimumBitFlipsToConvertNumber {

    public int minBitFlips(int start, int goal) {
        int value = start^goal;
        int count = 0;
        while (value != 0) {
            value &= (value - 1); // 제거된 비트가 `1`이 되는 비트만 남기게 됩니다.
            count++;
        }
        return count;
    }
}
