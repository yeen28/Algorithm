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
            if(sum == target){
                answer++;
            }
            return;
        }
        
        // 빼기
        sum += (-1 * numbers[idx]);
        dfs(idx+1, sum);
        
        // 더하기
        sum += (numbers[idx]*2); // 이전 단계에서 빼준 것을 보완하기 위해 2배를 더해준다.
        dfs(idx+1, sum);
    }
}
