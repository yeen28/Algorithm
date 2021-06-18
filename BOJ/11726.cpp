#include <bits/stdc++.h>
using namespace std;

void dp(int n) {
    vector<long long> memo(n, 0);

    memo[0] = 1;
    memo[1] = 2;

    for (int i = 2; i < n; i++)
        memo[i] = (memo[i - 2] + memo[i - 1]) % 10007;

    cout<< memo[n-1];
}

int main() {
    int n;
    cin>> n;

    dp(n);

    return 0;
} 
