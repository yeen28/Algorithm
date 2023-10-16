// https://y-e-un28.tistory.com/528

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public boolean solution(String[] phone_book) {
 		if (phone_book.length == 1) {
			return false;
		}

		Map<String, Integer> map = new HashMap<>();
		int idx = 0;
		for (String str : phone_book) {
			map.put(str, idx++);
		}

		for (String str : phone_book) {
			for (int j = 0; j < str.length(); j++) {
				if (map.containsKey(str.substring(0, j))) {
					return false;
				}
			}
		}

		return true;
	}
}
