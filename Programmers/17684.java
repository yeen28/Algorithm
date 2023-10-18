// https://y-e-un28.tistory.com/531

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	private Map<String, Integer> dictionary = new HashMap<>();

	/**
	 * 사전 초기화
	 */
	public void initDictionary() {
		for (int i = 'A'; i <= 'Z'; i++) {
			dictionary.put(String.valueOf((char) i), i - 'A' + 1);
		}
	}

	public List<Integer> solution(String msg) {
		List<Integer> answer = new ArrayList<>();

		initDictionary();

		int lengthDictionary = dictionary.size();
		int idx = 1;
		for (int i = 0; i < msg.length(); i++) {
			// 사전에 없는 문자열이 나올 때까지 확인
			while (idx + i <= msg.length() && dictionary.containsKey(msg.substring(i, idx + i))) {
				idx++;
			}

			answer.add(dictionary.get(msg.substring(i, idx + i - 1)));

			if (idx + i > msg.length()) {
				break;
			}

			dictionary.put(msg.substring(i, idx + i), ++lengthDictionary);

			i += idx - 2; // 사전에 있는 w는 제거
			idx = 1;
		}

		return answer;
	}
}
