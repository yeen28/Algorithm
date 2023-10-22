// https://y-e-un28.tistory.com/536

import java.util.HashMap;
import java.util.Map;

class Solution {
	private final Map<String, Integer> dictionary = new HashMap<>();
	private final String[] WORDS = {"A", "E", "I", "O", "U"};
	private int number = 0;

	public int solution(String word) {
		recursive("");
		return dictionary.get(word);
	}

	private void recursive(String str) {
		dictionary.put(str, number++);

		if (str.length() >= 5) {
			return;
		}

		for (String word : WORDS) {
			recursive(str.concat(word));
		}
	}
}
