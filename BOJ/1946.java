import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private final Map<Integer, Integer> mapScore = new HashMap<>();
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
		int rank = mapScore.get(1);

		for (int i = 2; i < mapScore.size() + 1; i++) {
			if (rank > mapScore.get(i)) {
				rank = mapScore.get(i);
				result++;
			}
		}
	}

	private void input(BufferedReader br) throws IOException {
		int people = Integer.parseInt(br.readLine());

		for (int i = 0; i < people; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			mapScore.put(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
		}
	}
}
