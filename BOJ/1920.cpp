#include <bits/stdc++.h>

int *a;
int *b;

void binarySearch(int n, int m){

    for(int i=0; i<m; i++){
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (a[mid] > b[i])
                right = mid - 1;
            else if(a[mid] < b[i])
                left = mid+1;
            else{
                std::cout<< 1 << '\n';
                break;
            }
        }
        if(left > right){
            std::cout<< 0 << '\n';
        }
    }
}

int main(){
    // 입력
    int M,N;
    
    std::cin >> N;
    a = new int[N];
    for(int i=0; i<N; i++){
        std::cin>> a[i];
    }
    std::sort(a, a+N);
    
    std::cin>>M;
    b = new int[M];
    for(int i=0; i<M; i++){
        std::cin>> b[i];
    }

    binarySearch(N, M);

    return 0;
}
