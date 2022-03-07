import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    
    private List<Integer> tmp;
	private List<Integer> answer;
    
    public List<Integer> solution(int[] array, int[][] commands) {
        answer = new ArrayList<Integer>();
		
		tmp = new ArrayList<Integer>();

		for(int i=0; i<commands.length; i++) {
			tmp.clear();
			proc(array, commands[i]);
		}

		return answer;
	}

	public void proc(int[] array, int[] command) {
		for (int i = command[0] - 1; i < command[1]; i++) {
			tmp.add(array[i]);
		}

		Collections.sort(tmp);

		answer.add(tmp.get(command[2] - 1));
	}
}
