import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static String a;
	private static String b;

	public static void main(String[] args) throws IOException {
		input();
		proc();
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		a = input[0];
		b = input[1];
	}

	public static void proc() {
		int minA = Integer.parseInt(a.replace('6', '5'));
		int minB = Integer.parseInt(b.replace('6', '5'));
		int min = minA + minB;

		int maxA = Integer.parseInt(a.replace('5', '6'));
		int maxB = Integer.parseInt(b.replace('5', '6'));
		int max = maxA + maxB;

		System.out.printf("%d %d%n", min, max);
	}
}
