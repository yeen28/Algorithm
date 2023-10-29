// https://y-e-un28.tistory.com/541

class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (String skillTree : skill_trees) {
			int skillIdx = 0;
			for (int j = 0; j < skillTree.length(); j++) {
				int idx = skill.indexOf(String.valueOf(skillTree.charAt(j)));

				if (idx == -1) {
					continue;
				}

				if (idx != skillIdx) {
					answer--;
					break;
				}

				skillIdx++;
			}
			answer++;
		}
		return answer;
	}
}
