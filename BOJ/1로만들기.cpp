#include <iostream>

int _min(int arr[], int oneMinus, int remainder2, int remainder3){
    // 적은 횟수 찾기
    int m = std::min(arr[oneMinus], arr[remainder2]);
    m = std::min(m, arr[remainder3]);
    return m;
}

void makeOne(int n){
    int min;
    int *arr = new int[n+1];

    arr[0] = 999999;
    arr[1] = 0;
    arr[2] = 1;
    arr[3] = 1;

    // n까지 횟수를 배열에 저장
    for(int i=4; i<=n; i++){
        int oneMinus=0, remainder2=0, remainder3=0;
        if(i%3 == 0) remainder3 = i/3;
        if(i%2 == 0) remainder2 = i/2;
        oneMinus = i-1;

        arr[i] = _min(arr, oneMinus, remainder2, remainder3)+1;
    }

    std::cout << arr[n] << '\n';

    delete[] arr;
}

int main(){
    int n;
    std::cin>>n;

    makeOne(n);

    return 0;
}
