class Solution {
    private int[] numbers;
    private int target;
    public static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int idx, int sum){
        if(idx == numbers.length){
            if(sum == target) answer++;
            
            return;
        }
        
        // 빼기
        dfs(idx+1, sum - numbers[idx]);
        
        // 더하기
        dfs(idx+1, sum + numbers[idx]);
    }
}
