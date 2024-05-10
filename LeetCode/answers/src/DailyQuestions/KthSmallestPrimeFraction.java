package DailyQuestions;

public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0, right = 1;
        int[] result = new int[2];

        while (true) {
            double mid = left + (right - left) / 2;
            int count = 0;
            int p = 0, q = 1;

            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && arr[i] >= arr[j] * mid) {
                    j++;
                }
                count += n - j;
                if (j < n && p * arr[j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[j];
                }
            }

            if (count == k) {
                result[0] = p;
                result[1] = q;
                break;
            } else if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return result;
    }
}
