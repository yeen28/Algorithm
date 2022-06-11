#include <iostream>
#include <cassert>

#include <vector>
#include <algorithm>

int main(){
    int n;
    std::cin>>n;
    std::vector<int> p;
    for(int i=0; i<n; i++){
        int m;
        std::cin>>m;
        p.push_back(m);
    }
    std::sort(p.begin(), p.end());
    for(int i=0; i<n; i++){
        std::cout<<p[i]<<'\n';
    }
    return 0;
}
