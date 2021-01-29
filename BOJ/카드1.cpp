#include <iostream>
#include <queue>

int main() {
	std::queue<int> q;

	// 카드 개수 
	int n;
	std::cin >> n;

	int i = 0;

	for (int j = 1; j <= n; j++) {
		q.push(j);
	}

	// 카드가 한 장 이상 남아있는 경우
	while (q.size() != 1) {

		// 버리는 카드
		if (i % 2 == 0) {
			std::cout << q.front() << ' ';
			q.pop();
		}

		// 맨 밑으로 넣는 카드
		else {
			int front = q.front();
			q.pop();
			q.push(front);
		}

		i++;
	}

	// 카드가 한 장만 남는 경우
	std::cout << q.front() << std::endl;

	return 0;
}
