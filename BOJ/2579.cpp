#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin>> n;
    n++;

    vector<int> step(n, 0);
    vector<int> dp(n, 0);

    for(int i=1; i<n; i++) {
        int score;
        cin>> score;
        step[i] = score;
    }

    /* DP */
    for (int i = 1; i < 3; i++) {
        if(i == 1) dp[i] = step[i];
        else dp[i] = step[i] + dp[i-1];
    }

    // 이전 계단을 밟고 올라온 경우, 이전 계단을 밟지 않고 올라온 경우
    for (int i = 3; i < n; i++)
        dp[i] = max(step[i] + step[i - 1] + dp[i - 3], step[i] + dp[i - 2]);

    // 결과출력
    cout<< dp[n-1];

    return 0;
}
