import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
	}

	private void proc(int n) {
		int sum = 0;
		int answer = 0;
		int startP = 1; // 시작 포인터
		int endP = 1; // 끝 포인터

		sum += startP;
		while (startP <= n) {
			if (sum == n) {
				answer++;
				sum -= (startP++);

			} else if (sum > n) {
				sum -= startP;
				startP++;

			} else {
				sum += (++endP);
			}
		}

		System.out.println(answer);
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		proc(n);
	}
}