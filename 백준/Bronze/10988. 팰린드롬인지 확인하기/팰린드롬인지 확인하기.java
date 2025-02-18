import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
	}

	private void proc(final String input) {
		char[] chArray = input.toCharArray();
		int i = 0;
		int j = chArray.length - 1;

		while (i < j) {
			if (chArray[i] != chArray[j]) {
				System.out.println(0);
				return;
			}

			i++;
			j--;
		}

		System.out.println(1);
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		proc(input);
	}
}