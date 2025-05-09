import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int[] inputArr;
	private int x;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		int answer = 0;

		Arrays.sort(inputArr);

		int i = 0;
		int j = inputArr.length - 1;
		while (i < j) {
			int tmpNum = inputArr[i] + inputArr[j];
			if (tmpNum == x) {
				answer++;
				i++;
				j--;
			} else if (tmpNum > x) {
				j--;
			} else {
				i++;
			}
		}

		System.out.println(answer);
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		inputArr = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int i = 0;
		while (stk.hasMoreTokens()) {
			inputArr[i] = Integer.parseInt(stk.nextToken());
			i++;
		}

		x = Integer.parseInt(br.readLine());
	}
}
