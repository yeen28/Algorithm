#include <bits/stdc++.h>

std::pair<int, int> conf[100000];

int main(){
    int ans=0, t=0;
    
    // 회의 개수
    int confCnt;
    std::cin>> confCnt;
    
    // 회의 시간 입력받기
    for(int i=0; i<confCnt; i++)
        std::cin>> conf[i].second >> conf[i].first;
    std::sort(conf, conf+confCnt);

    for(int i=0; i<confCnt; i++){
        // 이미 회의가 시작한 경우,
        if(conf[i].second < t) continue;

        ans++;
        t = conf[i].first;
    }
    std::cout<< ans;
}
