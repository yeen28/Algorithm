#include <bits/stdc++.h>

int arr[9];
int sumDiffer=0;

void findSeven(){
    for(int i=0; i<8; i++){
        for(int j=1; j<9; j++){
            if(arr[i]+arr[j] == sumDiffer){
                arr[i] = -1;  arr[j] = -1;
                return;
            }
        }
    }
}

int main(){
    for(int i=0; i<9; i++){
        std::cin >> arr[i];   // 9명의 키 입력
        sumDiffer += arr[i];
    }
    std::sort(arr, arr+9);
    sumDiffer = sumDiffer-100;

    findSeven();

    // 결과 출력
    for(int i=0; i<9; i++){
        if(arr[i] > 0){
            std::cout<< arr[i] << '\n';
        }
    }

    return 0;
}
