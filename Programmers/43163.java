class Solution {
  
  private String[] words;
  private int answer;
  private boolean[] visited;
  private static final int MAX = 100000;

  public boolean isInWords(String target, String[] words) {
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(target)) return true;
    }

    return false;
  }

  public boolean is1Diff(String a, String b) {
    int diff = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) diff++;
    }

    if (diff == 1) return true;
    return false;
  }

  public void dfs(String target, int idx, int cnt) {
    if(answer <= cnt) return;
    
    if (words[idx].equals(target)) {
      answer = cnt;
      return;
    }

		for (int i = 0; i < words.length; i++) {
			if (!visited[i] && is1Diff(words[idx], words[i])) {
				visited[i] = true;
				dfs(target, i, cnt+1);
				visited[i] = false;
			}
		}

		return;
	}
  
  public int solution(String begin, String target, String[] words) {
    this.words = words;
    visited = new boolean[words.length];
    answer = MAX;

    // words에 target이 있는지 확인
    if (!isInWords(target, words)) return 0;

    // begin과 words 비교
    for (int i = 0; i < words.length; i++) {
      if (is1Diff(begin, words[i])) {
        visited[i] = true;
        dfs(target, i, 1);
        break;
      }
    }
    
    if(answer == MAX) return 0;

		return answer;
	}
}
