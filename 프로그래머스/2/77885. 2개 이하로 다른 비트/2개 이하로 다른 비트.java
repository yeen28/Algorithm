class Solution {
	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			String binaryString = String.format("%18s", Long.toBinaryString(numbers[i])).replace(" ", "0");

			for (int j = binaryString.length() - 1; j >= 0; j--) {
				if (numbers[i] % 2 == 0) {
					binaryString = changChar(binaryString, j, "1");
					break;
				}

				if (binaryString.charAt(j) == '0') {
					binaryString = changChar(binaryString, j, "1");
					binaryString = changChar(binaryString, j + 1, "0");
					break;
				}
			}

			answer[i] = Long.parseLong(binaryString, 2);
		}
		return answer;
	}

	private String changChar(String srcString, int idx, String changString) {
		return srcString.substring(0, idx) + changString + srcString.substring(idx + 1);
	}
}