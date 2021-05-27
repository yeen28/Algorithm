#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> edge) {
    
    // 연결된 노드 입력
    vector<vector<int>> edges(n+1, vector<int> (n+1, 0));
    for(auto e : edge){
        edges[e[0]][e[1]] = 1;
        edges[e[1]][e[0]] = 1;
    }
    
    // bfs    
    vector<bool> visited(n+1, false);
    vector<int> dist(n+1, 0);  // 거리
    queue<int> q;
    
    q.push(1);
    visited[1] = true;
    
    while(!q.empty()){
        int u = q.front();
        q.pop();
        
        for(int i=1; i<=n; i++)
            if(edges[u][i] == 1 && visited[i] == false){ 
            // 간선이 연결되어 있고 아직 방문하지 않은 경우
                dist[i] = dist[u]+1;
                visited[i] = true;
                q.push(i);
            }
    }
    
    int answer=0;
    int max = *max_element(dist.cbegin(), dist.cend());
    for(int i=2; i<=n; i++)
        if(dist[i] == max) 
            answer++;
    
    return answer;
}
