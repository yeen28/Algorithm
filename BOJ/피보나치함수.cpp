#include <iostream>

void fibonacci(int n){
    int arr[2][45]={};
    
    // fibonacci(0)
    arr[0][0] = 1;
    arr[1][0] = 0;
    // fibonacci(1)
    arr[0][1] = 0;
    arr[1][1] = 1;

    for(int i=2; i<=n; i++){
        arr[0][i] = arr[0][i-2] + arr[0][i-1];
        arr[1][i] = arr[1][i-2] + arr[1][i-1];
    }

    std::cout<<arr[0][n]<<' '<<arr[1][n] << '\n';
}
int main(){
    int testCase, n;
    std::cin >> testCase;

    for(int i=0; i<testCase; i++){
        std::cin>>n;
        fibonacci(n);
    }

    return 0;
}
