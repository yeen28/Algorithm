#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;

	for (int i = 0; i < numbers.size()-1; i++) {
		for (int j = i+1; j < numbers.size(); j++) {
			answer.push_back(numbers[i]+numbers[j]);
		}
	}

	// 오름차순 정렬
	std::sort(answer.begin(), answer.end());
	// 중복 제거.    unique만 써주면 뒤에 쓰레기값이 생기므로 erase로 지워줌.
	answer.erase(std::unique(answer.begin(), answer.end()), answer.end());
    return answer;
}
