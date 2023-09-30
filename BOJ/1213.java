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
		StringBuilder result = new StringBuilder();
		int odd = 0;
		int mid = -1;
		int[] alphabet = new int[26];

		for (int i = 0; i < name.length; i++) {
			alphabet[name[i] - 65]++;
		}

		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] % 2 != 0) {
				odd++;
				mid = i;
			}

			if (odd > 1) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
		}

		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] /= 2;

			for (int j = 0; j < alphabet[i]; j++) {
				result.append((char)(i + 'A'));
			}
		}

		StringBuilder after = new StringBuilder();
		for (int i = 1; i <= result.length(); i++) {
			char[] charArray = result.toString().toCharArray();
			after.append(charArray[charArray.length - i]);
		}

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
