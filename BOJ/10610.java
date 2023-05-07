import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private char[] num;
	private String result;

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
		System.out.println(result);
	}

	private void proc() {
		// 주어진 숫자 배열을 내림차순으로 정렬합니다.
		Arrays.sort(num);
		reverseArray(num);

		// 마지막 숫자가 0이 아니면 30의 배수가 될 수 없다.
		if (num[num.length - 1] != '0') {
			result = "-1";
			return;
		}

		// 각 숫자의 합이 30 배수여야 한다.
		long sum = 0;
		for (int k = 0; k < num.length; k++) {
			sum += Long.parseLong(String.valueOf(num[k]));
		}
		if (sum % 3 != 0) {
			result = "-1";
			return;
		}

		// 주어진 숫자 배열을 이용하여 가장 큰 수를 만듭니다.
		StringBuilder sb = new StringBuilder();
		for (char digit : num) {
			sb.append(digit);
		}

		result = sb.toString();
	}

	public static void reverseArray(char[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = br.readLine().toCharArray();
	}
}
