#include <iostream>
#include <vector>
#include <algorithm>

int maxSides(std::vector<int> &sides){   // sides의 별칭
// int maxSides(std::vector<int> sides){  // sides를 복사하여 독립적인 sides가 됨.

    // 세 변의 길이의 합이 최대인 삼각형 만들기
    for(int i=sides.size()-1; i>1; i--){
        int c = sides[i], b = sides[i-1], a = sides[i-2];
        if(c < a + b) return a + b + c;
    }
    return -1;
}

int main(){
    int N;
    std::cin>>N;
    std::vector<int> sides(N, 0);

    // N개의 빨대 길이
    for(int i=0; i<N; i++) std::cin>>sides[i];

    std::sort(sides.begin(), sides.end());

    std::cout<<maxSides(sides)<<'\n';

    return 0;
}
