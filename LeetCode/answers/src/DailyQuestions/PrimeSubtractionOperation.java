package DailyQuestions;

public class PrimeSubtractionOperation {

	private List<Integer> primes;

	public boolean primeSubOperation(int[] nums) {
		primes = findPrimes(1000);
		int prev = 0;
		for (int num : nums) {
			if (num <= prev) {
				return false;
			}
			int i = bisectLeft(num - prev) - 1;
			if (i != -1) {
				num -= primes.get(i);
			}
			prev = num;
		}
		return true;
	}

	private int bisectLeft(int target) {
		int left = 0;
		int right = primes.size();
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (primes.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	public static List<Integer> findPrimes(int limit) {
		List<Integer> primes = new ArrayList<>();

		for (int i = 2; i <= limit; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}

		return primes;
	}

	private static boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
