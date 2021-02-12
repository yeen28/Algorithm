#include <iostream>
#include <cassert>

#include <vector>
#include <algorithm>

int main(){
    int answer = 0, n, k;
    std::cin >> n >> k;
    std::vector<int> money;

    // 동전의 종류
    for (int i = 0; i < n; i++) {
        int kind;
        std::cin >> kind;
        money.push_back(kind);
    }

    for(int i=money.size()-1; i >= 0; i--){
        if(k<0) break;
        if(money[i]<=k){
            answer++;
            k -= money[i];
        if(money[i]<=k) i++;
        }
    }
  
    std::cout<<answer;
}
