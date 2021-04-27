#include <bits/stdc++.h>

int main(){
    int n,m;
    std::cin >> n >> m;
    int *a = new int[n];
    for(int i=0; i<n; i++){
        std::cin>> a[i];
    }

    int sum=0, idx, answer=0;
    for(int i=0; i<n; i++){
        if(sum == 0){
            idx = i;
        }

        sum += a[i];

        if(sum > m){
            sum = 0;
            i = idx;
            continue;
        }
        else if(sum == m){
            answer++;
            sum=0;
            i = idx;
        }
    }

    std::cout<< answer << '\n';

    return 0;
}
