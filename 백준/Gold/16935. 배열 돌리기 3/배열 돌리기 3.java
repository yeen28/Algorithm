import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[][] arr;
	private int[] calcs;
	int N, M;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		for (int calc : calcs) {
			switch (calc) {
				case 1: // 상하반전
					doUpsideDown();
					break;
				case 2: // 좌우반전
					doReverseLAndR();
					break;
				case 3: // 90도 오른쪽으로 회전
					doRightRotations();
					break;
				case 4: // 90도 왼쪽으로 회전
					doLeftRotations();
					break;
				case 5: // 4분할
					doSubArrayFive();
					break;
				default:
					doSubArraySix();
			}
		}

		for (int[] nums : arr) {
			for (int num : nums) {
				System.out.printf("%d ", num);
			}
			System.out.println();
		}
	}

	private void doUpsideDown() {
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[N - 1 - i][j];
				arr[N - 1 - i][j] = tmp;
			}
		}
	}

	private void doReverseLAndR() {
		for (int i = 0; i < M/2; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = arr[j][i];
				arr[j][i] = arr[j][M - 1 - i];
				arr[j][M - 1 - i] = tmp;
			}
		}
	}

	private void changeNM() {
		int tmp = N;
		N = M;
		M = tmp;
	}

	private void doRightRotations() {
		changeNM();
		int[][] result = new int[N][M];
		rightRotationsChange(result);
		arr = result;
	}

	private void rightRotationsChange(int[][] temp) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[j][M - 1 - i] = arr[i][j];
			}
		}
	}

	private void doLeftRotations() {
		changeNM();
		int[][] result = new int[N][M];
		leftRotationsChange(result);
		arr = result;
	}

	private void leftRotationsChange(int[][] temp) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[N - 1 - j][i] = arr[i][j];
			}
		}
	}

	private void doSubArrayFive() {
		int[][] result = new int[N][M];
		subarrayChange(result, 0, 0, 0, M/2);
		subarrayChange(result, 0, M/2, N/2, M/2);
		subarrayChange(result, N/2, M/2, N/2, 0);
		subarrayChange(result, N/2, 0, 0, 0);
		arr = result;
	}

	private void subarrayChange(int[][] temp, int x1, int y1, int x2, int y2) {
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[x2 + i][y2 + j] = arr[x1 + i][y1 + j];
			}
		}
	}

	private void doSubArraySix() {
		int[][] result = new int[N][M];
		subarrayChange(result, 0, 0, N/2, 0);
		subarrayChange(result, N/2, 0, N/2, M/2);
		subarrayChange(result, N/2, M/2, 0, M/2);
		subarrayChange(result, 0, M/2, 0, 0);
		arr = result;
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		int R = Integer.parseInt(stk.nextToken());

		arr = new int[N][M];
		calcs = new int[R];

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			calcs[i] = Integer.parseInt(stk.nextToken());
		}
	}
}