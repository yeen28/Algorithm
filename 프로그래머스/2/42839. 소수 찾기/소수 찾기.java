import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
	private Set<Long> result = new HashSet<>();
	private String numbers;
	private boolean[] visited;

	public int solution(String numbers) {
		this.numbers = numbers;
		visited = new boolean[numbers.length()];

		recursive("", 0);

		return result.size();
	}

	private void recursive(String str, int idx) {
		if (!Objects.equals(str, "")) {
			long num = Long.parseLong(str);
			if (prime(num)) {
				result.add(num);
			}
		}

		if (idx == numbers.length()) {
			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			recursive(str + numbers.charAt(i), idx + 1);
			visited[i] = false;
		}
	}

	private boolean prime(long num) {
		if (num == 0 || num == 1) {
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