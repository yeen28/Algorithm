import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>(); // index를 저장
        stack.push(0);
        
        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.peek()] = numbers[i];
                stack.pop();
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}