#include <iostream>
using namespace std;

int coloredPaper[130][130] = {NULL};   // 색종이
int N;  // 색종이 한 변의 길이
int white = 0, blue = 0;

// 분할된 영역이 모든 같은 색깔인지 확인
bool allSame(int color, int xs, int ys, int xe, int ye) {
	for (int i = xs; i < xe; i++) {
		for (int j = ys; j < ye; j++) {
			if ((color == 0 && coloredPaper[i][j] == 1) || (color == 1 && coloredPaper[i][j] == 0)) {
				return false;
			}
		}
	}
	return true;
}

// 분할
void cut(int xs, int ys, int xe, int ye) {
	int color = coloredPaper[xs][ys];

	if (!allSame(color, xs, ys, xe, ye)) {
		// x시작점, y시작점, x끝점, y끝점
		cut(xs, ys, (xs + xe) / 2, (ys + ye) / 2);    // 1사분면
		cut((xs + xe) / 2, ys, xe, (ys + ye) / 2);    // 2사분면
		cut(xs, (ys + ye) / 2, (xs + xe) / 2, ye);    // 3사분면
		cut((xs + xe) / 2, (ys + ye) / 2, xe, ye);    // 4사분면
		return;
	}

	if (color == 0) white++;
	else blue++;

	return;
}

int main() {
	cin >> N;

	// 각 칸에 색깔 입력
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> coloredPaper[i][j];
		}
	}

	cut(0, 0, N, N);

	cout << white << endl << blue << endl;   // 결과 출력
}
