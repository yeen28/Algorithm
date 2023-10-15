// https://y-e-un28.tistory.com/230

#include <string>
#include <vector>

using namespace std;

vector<int> gb_numbers;
int gb_target;
int answer = 0;

void dfs(int idx, int sum){
    if(idx == gb_numbers.size()){
        if(sum == gb_target){
            answer++;
        }
        return;
    }
    
    // 더하기
    sum += gb_numbers[idx];
    dfs(idx+1, sum);
    
    // 빼기
    sum += (-1) * (gb_numbers[idx]*2);
    dfs(idx+1, sum);    
}

int solution(vector<int> numbers, int target) {    
    gb_numbers = numbers;
    gb_target = target;
    
    dfs(0, 0);
    
    return answer;
}
