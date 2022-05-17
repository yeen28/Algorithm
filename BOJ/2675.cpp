#include<bits/stdc++.h>
using namespace std;

int T;

void proc(int R, string S) {
    for (int i = 0; i < S.length(); i++) {
        for (int j = 0; j < R; j++)
            cout << S[i];
	}
}

void input() {
    int R;
    string S;
    for (int testcase = 0; testcase < T; testcase++) {
        cin >> R >> S;
        proc(R, S);
        cout << "\n";
    }
}

int main() {
    cin >> T;
    input();
    
    return 0;
}
