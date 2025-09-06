class Solution {
    public int solution(int n, int w, int num) {
        int cnt = 0;
        while(num <= n) {
            num += (w - ((num-1) % w) -1) * 2 + 1;
            cnt++;
        }

        int answer = cnt;
        return answer;
    }
}