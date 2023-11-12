class Solution {
	private int[][] arr;
	private int[] answer = new int[2];

	public int[] solution(int[][] arr) {
		this.arr = arr;
		recursive(0, 0, arr.length);
		return answer;
	}

	private void recursive(int startX, int startY, int size) {
		if (check(startX, startY, size)) {
			answer[arr[startX][startY]]++;
			return;
		}

		recursive(startX, startY, size / 2);
		recursive(startX + size / 2, startY, size / 2);
		recursive(startX, startY + size / 2, size / 2);
		recursive(startX + size / 2, startY + size / 2, size / 2);
	}

	private boolean check(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[x][y] != arr[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}