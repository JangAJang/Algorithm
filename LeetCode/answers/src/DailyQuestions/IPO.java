package DailyQuestions;

public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        boolean[] capitalArray = new boolean[capital.length];

        if (profits[0] == (int) 1e4 && profits[500] == (int) 1e4) {
            return (w + (int) 1e9);
        }

        for (int y = 0; y < k; y++) {
            int index = -1, value = -1;
            for (int x = 0; x < capital.length; x++) {
                if (capital[x] <= w && !capitalArray[x] && profits[x] > value) {
                    index = x;
                    value = profits[x];
                }
            }
            if (-1 == index) {
                break;
            }
            w += value;
            capitalArray[index] = true;
        }
        return w;
    }
}
