// https://y-e-un28.tistory.com/529

import java.util.Arrays;

class Solution {
    public int solution(int n, int k) {
		int answer = 0;
		String intToRadix = Integer.toString(n, k);
		double[] arrNum = Arrays.stream(intToRadix.split("0")).filter(numStr -> !numStr.isEmpty()).mapToDouble(Double::parseDouble).toArray();

		for (double num : arrNum) {
			if (isPrime(num)) {
				answer++;
			}
		}

		return answer;
	}

	private boolean isPrime(double num) {
		if (num == 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
