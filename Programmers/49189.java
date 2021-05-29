import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] edge) {
        
        Queue<Integer> q = new LinkedList<>();  // 큐    
        boolean[][] edges = new boolean[n][n];   // 간선
        boolean[] visited = new boolean[n];    // 방문여부
        int[] dist = new int[n];  // 거리
        int answer = 0;
        
        // 연결된 노드 입력
        for(int i = 0; i < edge.length; i++){
            edges[edge[i][0]-1][edge[i][1]-1] = true;
            edges[edge[i][1]-1][edge[i][0]-1] = true;
        }
    
        // bfs
        q.add(1);
        visited[0] = true;
    
        while(!q.isEmpty()){
            int u = q.poll();
        
            for(int i = 0; i < n; i++)
                if(edges[u-1][i] == true && visited[i] == false){ 
                // 간선이 연결되어 있고 아직 방문하지 않은 경우
                    dist[i] = dist[u-1]+1;
                    visited[i] = true;
                    q.add(i+1);
                }
    }
    
        int max = Arrays.stream(dist).max().getAsInt();
        for(int i = 1; i < n; i++)
            if(dist[i] == max) 
                answer++;
        
        return answer;
    }
}
