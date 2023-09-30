// https://y-e-un28.tistory.com/520

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private char[] name;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	public void proc() {
		StringBuilder before = new StringBuilder();
		StringBuilder after;
		StringBuilder result = new StringBuilder();
		int odd = 0;
		int mid = -1;
		int[] alphabet = new int[26];

		// 각 문자의 개수를 저장
		for (char c : name) {
			alphabet[c - 65]++;
		}

		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] % 2 != 0) {
				odd++;
				mid = i;
			}

			if (odd > 1) { // 팰린드롬을 만들 수 없는 경우
				System.out.println("I'm Sorry Hansoo");
				return;
			}
		}

		// 팰린드롬 앞 부분 만들기
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] /= 2;
			before.append(String.valueOf((char) (i + 'A')).repeat(Math.max(0, alphabet[i])));
		}
		
		result.append(before);
		after = before.reverse();

		if (mid != -1) {
			result.append((char) (mid + 'A'));
		}

		result.append(after);

		System.out.println(result);
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		name = br.readLine().toCharArray();
	}
}
