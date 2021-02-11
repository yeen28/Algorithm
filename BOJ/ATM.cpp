#include <iostream>
#include <vector>
#include <algorithm>

// 최솟값
int min(std::vector<int> p){
    int mini=0;
    std::sort(p.begin(), p.end());
    for(int i=1; i<p.size(); i++){
        p[i] += p[i-1];
    }
    for(int i=0; i<p.size(); i++){
        mini += p[i];
    }
    return mini;
}

int main(){
    int n, p;
    std::vector<int> people;
    std::cin>>n;

    for(int i=0; i<n; i++){
        std::cin>>p;
        people.push_back(p);
    }

    std::cout<< min(people);
    return 0;
}
