// https://y-e-un28.tistory.com/539

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
	class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int solution(String dirs) {
		Set<String> dist = new HashSet<>();
		Point point = new Point(0, 0);

		int x = point.x;
		int y = point.y;
		for (int i = 0; i < dirs.length(); i++) {
			char dir = dirs.charAt(i);

			switch (dir) {
				case 'U' -> {
					x = point.x;
					y = point.y + 1;
				}
				case 'D' -> {
					x = point.x;
					y = point.y - 1;
				}
				case 'L' -> {
					x = point.x - 1;
					y = point.y;
				}
				case 'R' -> {
					x = point.x + 1;
					y = point.y;
				}
			}

			if (!isOOB(x, y)) {
				dist.add(String.format("%d%d%d%d", point.x, point.y, x, y));
				dist.add(String.format("%d%d%d%d", x, y, point.x, point.y));
				point = new Point(x, y);
			}
		}

		return dist.size() / 2;
	}

	private boolean isOOB(int x, int y) {
		return x < -5 || x > 5 || y < -5 || y > 5;
	}
}
