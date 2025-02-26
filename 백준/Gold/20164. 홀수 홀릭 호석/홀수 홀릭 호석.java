import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());

		cutNum(input, 0);

		System.out.println(min + " " + max);
	}

	private static void cutNum(int num, int cnt) {
		cnt += countOdd(num);

		if (num / 10 == 0) { // 1자리 수
			min = Math.min(min, cnt);
			max = Math.max(max, cnt);

		} else if (num / 100 == 0) { // 2자리 수
			int next = num / 10;
			next += num % 10;
			cutNum(next, cnt);

		} else { // 3자리 이상
			String numStr = String.valueOf(num);
			for (int i = 0; i < numStr.length() - 2; i++) {
				for (int j = i + 1; j < numStr.length() - 1; j++) {
					int next = Integer.parseInt(numStr.substring(0, i + 1));
					next += Integer.parseInt(numStr.substring(i + 1, j + 1));
					next += Integer.parseInt(numStr.substring(j + 1));

					cutNum(next, cnt);
				}
			}
		}
	}

	private static int countOdd(int num) {
		int cnt = 0;
		String numStr = String.valueOf(num);

		for (int i = 0; i < numStr.length(); i++) {
			if (Integer.parseInt(numStr.substring(i, i + 1)) % 2 != 0) {
				cnt++;
			}
		}

		return cnt;
	}
}