// https://y-e-un28.tistory.com/506

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
  // 우선순위 큐 : https://y-e-un28.tistory.com/317
	PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> minus = new PriorityQueue<>();
	int one = 0;
	int zero = 0;

	public static void main(String[] args) throws IOException {
		Main main = new Main();

		main.input();
		main.proc();
	}

	public void proc() {
		int result = 0;
		while (plus.size() >= 2) {
			result += plus.poll() * plus.poll();
		}
		if (!plus.isEmpty()) {
			result += plus.poll();
		}

		while (minus.size() >= 2) {
			result += minus.poll() * minus.poll();
		}
		if (!minus.isEmpty() && zero == 0) {
			result += minus.poll();
		}

		if (one > 0) {
			result += one;
		}

		System.out.println(result);
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				++zero;
			} else if (num == 1) {
				++one;
			} else if (num > 1) {
				plus.add(num);
			} else {
				minus.add(num);
			}
		}
	}
}
