import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private String[] oldSignboards;
	private String newSignboard;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		int answer = 0;

		for (String oldSignboard : oldSignboards) {
			answer += check(oldSignboard);
		}

		System.out.println(answer);
	}

	/**
	 * 재활용 가능한 간판인지 체크
	 * @param oldSignboard 오래된 간판
	 * @return
	 */
	private int check(String oldSignboard) {
		int nL = newSignboard.length();

		for (int i = 0; i < oldSignboard.length(); i++) {
			if (oldSignboard.charAt(i) == newSignboard.charAt(0)) {
				for (int j = i + 1; j < oldSignboard.length(); j++) {
					if (oldSignboard.charAt(j) == newSignboard.charAt(nL - 1)) { // 새로운 간판의 마지막 문자와 같은지 확인
						int gap = (j - i) / (nL - 1);

						// 일정한 간격이 아니여서 재활용할 수 없는 경우, continue
						if ((j - i) % (nL - 1) != 0) {
							continue;
						}
	
						// 오래된 간판에서 가운데에 있는 문자열들의 구성 비교
						int cnt = 1;
						while (cnt < nL) {
							if (oldSignboard.charAt(i + gap * cnt) == newSignboard.charAt(cnt)) {
								cnt++;
							} else {
								break;
							}
						}
	
						if (cnt == nL) {
							return 1;
						}
					}
				}
			}
		}

		return 0;
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		newSignboard = br.readLine();
		oldSignboards = new String[n];

		for (int i = 0; i < n; i++) {
			oldSignboards[i] = br.readLine();
		}
	}
}