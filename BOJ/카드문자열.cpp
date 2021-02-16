#include <iostream>
#include <vector>
#include <deque>

int main(){
    int T, N;
    std::cin>>T;

    for(int i=0; i<T; i++){
        std::cin>>N;
        std::vector<char> card(N, 0);
        std::deque<char> answer;
        for(int j=0; j<N; j++)
            std::cin>>card[j];

        // 사전 순으로 정렬
        answer.push_back(card[0]);
        for(int j=0; j<N-1; j++){
            if(((int)card[j] < (int)card[j+1]) || ((int)answer[0] < (int)card[j+1])) 
                answer.push_back(card[j+1]);
            else answer.push_front(card[j+1]);
        }

        // 결과 출력
        while(!answer.empty()){
            std::cout<<answer.front();
            answer.pop_front();
        }
        std::cout<<'\n';
    }

    return 0;
}
