#include <bits/stdc++.h>
using namespace std;

vector<int> rst(26, 0);
int ans = 0;

void solution(string str) {
    vector<char> array;
    for(int i=0; i<str.size(); i++) {
        array.push_back(str[i]);
    }

    int pos = pow(10, array.size()-1);   // 단어 자리수

    for(int i=0; i<array.size(); i++) {   // 가중치 부여
        rst[array[i] - 'A'] += pos;
        pos /= 10;
    }
}

int main(){
    int n;
    int w = 9;
    cin>> n;    // 단어 개수

    for(int i=0; i<n; i++) {
        string str;
        cin>> str;
        solution(str);
    }

    // 결과 계산
    sort(rst.rbegin(), rst.rend());
    
    for(int i=0; i<rst.size(); i++) {
        if(w == 0)
            break;
        ans += rst[i] * w--;
    }
    cout<< ans;

    return 0;
}
