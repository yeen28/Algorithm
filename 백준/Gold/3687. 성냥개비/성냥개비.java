import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private int[] inputArr;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		long[] minDp = new long[101];
		String[] maxDp = new String[101];
		Arrays.fill(minDp, Long.MAX_VALUE);
		minDp[2] = 1;
		minDp[3] = 7;
		minDp[4] = 4;
		minDp[5] = 2;
		minDp[6] = 6;
		minDp[7] = 8;
		minDp[8] = 10;

		// 가장 작은 수 구하기
		String[] addNum = {"1", "7", "4", "2", "0", "8"};
		for (int i = 9; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				long num = Long.parseLong(minDp[i - j] + addNum[j - 2]);
				minDp[i] = Math.min(num, minDp[i]);
			}
		}

		// 가장 큰 수 구하기
		addNum = new String[]{"0", "0", "1", "7", "4", "2", "0", "8"};
		maxDp[2] = "1";
		for (int i = 3; i <= 100; i++) {
			String strNum = "";

			if (i % 2 == 0) {
				strNum += "1".repeat(i / 2);

			} else {
				int n = i / 2 - 1;
				strNum += "1".repeat(n);
				strNum = "7" + strNum;
			}

			maxDp[i] = strNum;
		}

		for (int input : inputArr) {
			System.out.printf("%d %s\n", minDp[input], maxDp[input]);
		}
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		inputArr = new int[n];
		for (int i = 0; i < n; i++) {
			inputArr[i] = Integer.parseInt(br.readLine());
		}
	}
}