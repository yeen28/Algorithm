#include <bits/stdc++.h>
using namespace std;

int n;

void bfs(vector<vector<int>> com){
    vector<bool> visited(n+1, false);
    queue<int> q;
    int cnt = 0;

    q.push(1);
    visited[1] = true;

    while(!q.empty()){
        int u = q.front();
        q.pop();

        for(int i=1; i<=n; i++)
            if((!visited[i]) && com[u][i]) {
                q.push(i);
                cnt++;
                visited[i] = true;
            }
    }
    cout<< cnt;
}

int main(){
    int edge;
    cin>> n >> edge;
    vector<vector<int>> com(n+1, vector<int>(n+1, 0));


    for(int i=0; i<edge; i++){
        int a, b;
        cin>> a >> b;
        com[a][b] = 1;
        com[b][a] = 1;
    }

    bfs(com);

    return 0;
}
