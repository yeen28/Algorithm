import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
	private List<String> str1Subset = new ArrayList<>();
	private List<String> str2Subset = new ArrayList<>();

	public int solution(final String str1, final String str2) {
		int answer = 0;
		String lowerCaseStr1 = str1.toLowerCase();
		String lowercaseStr2 = str2.toLowerCase();

		makeSubset(lowerCaseStr1, lowercaseStr2);

		int listTotalCount = str1Subset.size() + str2Subset.size();
		int countIntersection = getCountIntersection();
		int countUnion = listTotalCount - countIntersection;
        if (countUnion == 0) {
            return 65536;
        }

		answer = (int) ((double) countIntersection / (double) countUnion * 65536);
		return answer;
	}

	private int getCountIntersection() {
		int countIntersection = 0;

		for (String str1 : str1Subset) {
			if (str2Subset.contains(str1)) {
				str2Subset.remove(str2Subset.indexOf(str1));
				countIntersection++;
			}
		}

		return countIntersection;
	}

	private boolean notEnglish(char ch) {
		return ch < 'a' || ch > 'z';
	}
    
	private void makeSubset(String str1, String str2) {
		char[] charStr1 = str1.toCharArray();
		char[] charStr2 = str2.toCharArray();

		for (int i = 0; i < str1.length() - 1; i++) {
			if (notEnglish(charStr1[i]) || notEnglish(charStr1[i+1])) {
				continue;
			}
			str1Subset.add(charStr1[i] + "" + charStr1[i+1]);
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			if (notEnglish(charStr2[i]) || notEnglish(charStr2[i+1])) {
				continue;
			}
			str2Subset.add(charStr2[i] + "" + charStr2[i+1]);
		}
	}
}
