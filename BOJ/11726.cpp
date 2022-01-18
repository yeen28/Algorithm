// i)
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

////////////////////////////////////////////////////////
/* // ii)
#include<iostream>
using namespace std;

int n;
int dp[5000];

void input(){
    cin>>n;
}

void proc(){
    dp[0]=1;
    dp[1]=2;
    for(int i=2; i<n; i++){
        dp[i]=(dp[i-1]+dp[i-2])%10007;
    }
}

int main(){
    input();
    proc();
    cout<<dp[n-1];
}
*/
