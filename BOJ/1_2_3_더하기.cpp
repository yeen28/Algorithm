#include <iostream>
#include <vector>

int dp(int n){
    std::vector<int> arr(n+1, 0);
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;
    for(int i=4; i<=n; i++){
        arr[i] += arr[i-1] + arr[i-2] + arr[i-3];
    }
    return arr[n];
}

int main(){
    int testCase;
    std::cin>>testCase;

    for(int i=0; i<testCase; i++){
        int n;
        std::cin>>n;

        std::cout<<dp(n)<<'\n';
    }
  return 0;
}
