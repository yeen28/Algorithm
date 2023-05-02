import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int[] documentScore;
	private int result;

	public static void main(String[] args) {
		Main main = new Main();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// testcase
			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				main.input(br);
				main.proc();
				main.print();
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void print() {
		System.out.println(result);
	}

	private void proc() {
		result = 1;
		int rank = documentScore[1];
		for (int i = 2; i < documentScore.length; i++) {
			if (rank > documentScore[i]) {
				rank = documentScore[i];
				result++;
			}
		}
	}

	private void input(BufferedReader br) throws IOException {
		int people = Integer.parseInt(br.readLine());
		documentScore = new int[people + 1];

		for (int i = 0; i < people; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			documentScore[Integer.parseInt(stk.nextToken())] = Integer.parseInt(stk.nextToken());
		}
	}
}
