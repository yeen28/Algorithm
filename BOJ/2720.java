import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private int[] inputCents;
	private List<String> results = new ArrayList<>();

	public static void main(String[] args) {
		Main main = new Main();

		try {
			main.input();
			main.proc();
			main.print();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void print() {
		for (String result : results) {
			System.out.println(result);
		}
	}

	private void proc() {
		final int QUARTER = 25;
		final int DIME = 10;
		final int NICKEL = 5;

		for (int inputCent : inputCents) {
			int quarter = inputCent / QUARTER;
			int remain = inputCent % QUARTER;
			int dime = remain / DIME;
			remain %= DIME;
			int nickel = remain / NICKEL;
			int penny = remain % NICKEL;

			results.add(String.format("%s %s %s %s", quarter, dime, nickel, penny));
		}
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		inputCents = new int[n];

		for (int i = 0; i < n; i++) {
			inputCents[i] = Integer.parseInt(br.readLine());
		}
	}
}
