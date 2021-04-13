#include <bits/stdc++.h>

int l, c;
char ch[16]={};
std::vector<char> pw;

void backtracking(int idx, int mo, int ja){

    if(pw.size() == l){

        // 조건에 맞지 않는 경우
        if((mo < 1) || (ja < 2))
            return;

        // 조건에 부합하면 출력
        else {
            for(int i=0; i<l; i++)
                std::cout<< pw[i];    
            std::cout<< '\n';
        }
    }

    else{
        
        for(int i=idx; i<c; i++){
            pw.push_back(ch[i]);

            if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u')
                backtracking(i + 1, mo + 1, ja);

            else
                backtracking(i + 1, mo, ja + 1);

            pw.pop_back();
        }
    }
}

int main(){
    std::cin>> l >> c;

    for(int i=0; i<c; i++)
        std::cin>> ch[i];

    // 입력을 오름차순으로 정렬
    std::sort(ch, ch+c);

    backtracking(0, 0, 0);

    return 0;
}
