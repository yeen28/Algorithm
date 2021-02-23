#include <iostream>
#include <vector>
#include <algorithm>

int dp(std::vector<std::vector<int>> arr, int n){
    for(int i=1; i<n; i++) {
        for(int j=0; j<=i; j++){
            if(j == 0)  // 가장 왼쪽에 있는 숫자
                arr[i][j] += arr[i-1][j];
            else if(j == i)  // 가장 오른쪽에 있는 숫자
                arr[i][j] += arr[i-1][j-1];
            else   // 왼쪽 위층, 오른쪽 위층의 합 중 더 큰 값
                arr[i][j] = std::max(arr[i-1][j-1]+arr[i][j], arr[i-1][j]+arr[i][j]);
        }
    }
    sort(arr[n-1].begin(), arr[n-1].end());
    return arr[n-1][n-1];
}

int main(){
    int n;
    std::cin>>n;
    std::vector<std::vector<int>> arr(n, std::vector<int> (n, 0));
    
    // 이차원 배열에 input
    for(int i=0; i<n; i++){
        for(int j=0; j<=i; j++){
            std::cin>>arr[i][j];
        }
    }

    std::cout<< dp(arr, n) <<'\n';

    return 0;
}
