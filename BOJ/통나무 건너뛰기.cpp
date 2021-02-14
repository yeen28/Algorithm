#include <iostream>

#include <algorithm>

int main(){
    int T;
    std::cin>>T;

    // 테스트 케이스만큼 반복
    for(int _case=0; _case<T; _case++){
        int n;
        std::cin>>n;
        int half = n/2;
        int *arr = new int[n];
        int *ansArr = new int[n];
        
        for(int i=0; i<n; i++) std::cin>>arr[i];
        int j=n-1;

        // 주어진 배열을 크기 순으로 정렬
        std::sort(arr, arr+n);

        // 가장 큰 숫자는 배열 중앙으로
        ansArr[half] = arr[j];

        // 최소 난이도가 나오도록 통나무 배치
        for(int i=1; i<=half; i++){
            j--;
            if(j<0) break;
            ansArr[half-i] = arr[j];
            j--;
            if(j<0) break;
            ansArr[half+i] = arr[j];
        }

        // 최소 난이도 출력
        int answer=0;
        for(int i=0; i<n-1; i++){
            int gap = abs(ansArr[i]-ansArr[i+1]);
            answer = std::max(answer, gap);
        }
        std::cout<<answer<<'\n';

        delete[] arr;
        delete[] ansArr;
    }
    return 0;
}
