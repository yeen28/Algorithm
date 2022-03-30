class Solution {
    private int[][] computers;
    private int n;
	
	public boolean dfs(int idx) {
		if(computers[idx][idx] == 0) 
			return false;
		computers[idx][idx] = 0;
		for(int i=0; i<n; i++) {
			if(computers[idx][i] == 1)
				dfs(i);
		}
		return true;
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		this.computers = computers;
        this.n = n;
		
		for(int i=0; i<n; i++) {
			if(computers[i][i] == 1 && dfs(i)) 
				answer++;
		}
		
		return answer;
	}
}
