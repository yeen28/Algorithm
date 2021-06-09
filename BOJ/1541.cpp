#include <bits/stdc++.h>
using namespace std;

int main(){
    string inputS;
    int answer = 0;
    bool isMinus = false;
    string s;
    cin>> inputS;

    for(int i = 0; i <= inputS.length(); i++) {
        if (inputS[i] == '+' || inputS[i] == '-' || i == inputS.length()) { // 연산자 또는 마지막문자(NULL)
            if (isMinus)
                answer -= stoi(s);
            else
                answer += stoi(s);

            s = "";

            if (inputS[i] == '-')
                isMinus = true;
        }

        else   // 피연산자 (숫자)
            s += inputS[i];
    }

    cout<< answer;

    return 0;
}
