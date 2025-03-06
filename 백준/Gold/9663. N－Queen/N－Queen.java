import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: https://www.acmicpc.net/problem/9663
 */
public class Main {
	static int N, ans;
	static int[] col; // col[i] : i번 행의 퀸은 col[i]번 열에 놓았다는 기록

	public static void main(String[] args) throws IOException {
		input();
		rec_func(1);
		System.out.println(ans);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N + 1];
	}

	/**
	 * 서로 공격하는 퀸들이 없는지 체크
	 * @return
	 */
	static boolean validity_check() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (attackable(i, col[i], j, col[j])) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param r1 첫번째 퀸 위치
	 * @param c1 첫번째 퀸 위치
	 * @param r2 두번째 퀸 위치
	 * @param c2 두번째 퀸 위치
	 * @return 공격 가능 여부
	 */
	static boolean attackable(int r1, int c1, int r2, int c2) {
		// 같은 열에 존재
		if (c1 == c2) {
			return true;
		}

		// 대각선에 존재
		if (r1 - c1 == r2 - c2) {
			return true;
		}

		// 대각선에 존재
		if (r1 + c1 == r2 + c2) {
			return true;
		}

		return false;
	}

	/**
	 * row 번 ~ N 번 행에 대해서는 가능한 퀸을 놓는 경우의 수 구하기
 	 */
	static void rec_func(int row) {
		if (row == N + 1) { // 각 행마다 퀸 배치를 완료한 경우
			ans++;
		} else {
			for (int c = 1; c <= N; c++) {
				// valid check
				boolean possible = true;
				for (int i = 1; i <= row - 1; i++) {
					if (attackable(row, c, i, col[i])) {
						possible = false;
						break;
					}
				}

				if (possible) {
					col[row] = c;
					rec_func(row + 1);
					col[row] = 0;
				}
			}
		}
	}
}
