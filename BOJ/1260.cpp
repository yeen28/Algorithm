#include <iostream>
#include <vector>
#include <queue>

std::vector<std::vector<bool>> table;
std::vector<bool> visited;

// DFS
void dfs(int v){
    visited[v] = true;
    std::cout<< v+1 << ' ';

    for(int i = 0; i < table.size(); i++) {
        if (table[v][i] && (!visited[i])){
            dfs(i);
        }
    }
}

// BFS
void bfs(int v){
    int n = table.size();
    std::queue<int> q;

    q.push(v);
    visited[v-1] = true;

    while(!q.empty()){
        int u = q.front();
        std::cout << u << ' ';
        q.pop();

        for(int i=0; i<n; i++) {
            if ((!visited[i]) && table[u-1][i]){
                q.push(i+1);
                visited[i] = true;
            }
        }
    }
}

int main(){
    /* n : 정점의 개수
       m : 간선의 개수
       v : 탐색을 시작할 정점의 번호 */
    int n, m, v;
    std::cin>> n >> m >> v;
    table.resize(n, std::vector<bool>(n, false));
    visited.resize(n, false);

    // table 입력
    for(int i=0; i<m; i++) {
        int x, y;
        std::cin>> x >> y;
        table[x-1][y-1] = true;
        table[y-1][x-1] = true;
    }

    // DFS
    dfs(v-1);

    std::cout << '\n';
    visited.assign(n, false);

    // BFS
    bfs(v);

    return 0;
}
