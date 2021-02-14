#include <iostream>
#include <cassert>

#include <vector>
#include <algorithm>
#include <string>

int main(){
    std::string str;
    std::cin>>str;
    int o=0, l=0;

    if(str[0] == '0') o++;
    else l++;

    // 연속해서 나오지 않는 숫자는 해당 변수에서 1씩 증가
    for(int i=1; i<str.size(); i++){
        if(str[i] == '0' && str[i-1] != str[i]) o++;
        else if(str[i] == '1' && str[i-1] != str[i]) l++;
    }

    // 더 적은 횟수를 출력
    if(l < o) std::cout<<l;
    else std::cout<<o;

    return 0;
}
