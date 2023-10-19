// https://y-e-un28.tistory.com/532

class Solution {
    public String solution(int n, int t, int m, int p) {
		StringBuilder answer = new StringBuilder();
		StringBuilder input = new StringBuilder();

		int idx = 0;
		while (idx < t * m) {
			input.append(Integer.toString(idx++, n).toUpperCase());
		}

		// 결과 append
		int pos = p - 1;
		for (int i = 0; i < t; i++) {
			answer.append(input.charAt(pos));
			pos += m;
		}

		return answer.toString();
	}
}
