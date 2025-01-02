import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int N;
	private int K;
	List<Belt> conveyor = new ArrayList<>();

	static class Belt {
		int durability;
		boolean existRobot;

		public Belt(int durability) {
			this.durability = durability;
			existRobot = false;
		}
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		int answer = 0;
		int zeroDurabilityCnt = 0;

		while (zeroDurabilityCnt < K) {
			answer++;

			// 컨베이어벨트 회전 & 내리는 위치에 있는 로봇 내림(existRobot = false)
			conveyor.add(0, conveyor.remove(conveyor.size() - 1));
			conveyor.get(N - 1).existRobot = false;

			// 로봇 스스로 이동
			for (int i = N - 2; i > 0; i--) {
				// 현재 칸에 이동할 로봇이 없거나 다음 칸의 내구도가 0이거나 로봇이 존재하는 경우, 로봇은 움직이지 않는다.
				if (!conveyor.get(i).existRobot
						|| conveyor.get(i + 1).durability <= 0
						|| conveyor.get(i + 1).existRobot
				) {
					continue;
				}

				conveyor.get(i).existRobot = false;
				conveyor.get(i + 1).existRobot = true;
				conveyor.get(i + 1).durability--;
				if (conveyor.get(i + 1).durability <= 0) {
					zeroDurabilityCnt++;
				}
			}

			// 로봇 내릴 때
			conveyor.get(N - 1).existRobot = false;

			// 로봇 올릴 때
			if (conveyor.get(0).durability > 0) {
				conveyor.get(0).existRobot = true;
				conveyor.get(0).durability--;

				if (conveyor.get(0).durability <= 0) {
					zeroDurabilityCnt++;
				}
			}
		}

		System.out.println(answer);
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			conveyor.add(new Belt(Integer.parseInt(stk.nextToken())));
		}
	}
}