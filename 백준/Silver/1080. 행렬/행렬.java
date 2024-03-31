import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	private boolean[][] matrixA;
	private boolean[][] matrixB;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	public void proc() {
		int result = 0;
		int row = matrixA.length;
		int col = matrixA[0].length;

		if (row < 3 || col < 3) {
			if (notEquals(matrixA, matrixB)) {
				System.out.println(-1);
			} else {
				System.out.println(result);
			}
			return;
		}

		for (int i = 0; i <= row - 3; i++) {
			for (int j = 0; j <= col - 3; j++) {
				if (matrixA[i][j] != matrixB[i][j]) {
					result++;
					flip(matrixA, i, j);
				}
			}
		}

		if (notEquals(matrixA, matrixB)) {
			System.out.println(-1);
			return;
		}

		System.out.println(result);
	}

	private void flip(boolean[][] matrix, int row, int col) {
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				matrix[i][j] = !matrix[i][j];
			}
		}
	}

	private boolean notEquals(boolean[][] A, boolean[][] B) {
		return IntStream.range(0, A.length).anyMatch(i -> IntStream.range(0, A[i].length).anyMatch(j -> A[i][j] != B[i][j]));
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> number = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		int row = number.get(0);
		int col = number.get(1);
		matrixA = new boolean[row][col];
		matrixB = new boolean[row][col];

		// matrix A
		for (int i = 0; i < row; i++) {
			String line = br.readLine();
			for (int j = 0; j < col; j++) {
				matrixA[i][j] = Character.getNumericValue(line.charAt(j)) == 1;
			}
		}

		// matrix B
		for (int i = 0; i < row; i++) {
			String line = br.readLine();
			for (int j = 0; j < col; j++) {
				matrixB[i][j] = Character.getNumericValue(line.charAt(j)) == 1;
			}
		}
	}
}