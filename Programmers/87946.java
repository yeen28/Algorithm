// https://y-e-un28.tistory.com/525

class Solution {
    private int answer = 0;
    private boolean[] visited;
    private int[][] dungeons;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        dfs(0, k);

        return answer;
    }
    
    private void dfs(int depth, int k) {
        for (int i = 0; i < dungeons.length; i++) {
            if (i > dungeons.length - 1 || dungeons[i][0] > k || visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(depth + 1, k - dungeons[i][1]);
            visited[i] = false;
        }

        answer = Math.max(answer, depth);
    }
}
