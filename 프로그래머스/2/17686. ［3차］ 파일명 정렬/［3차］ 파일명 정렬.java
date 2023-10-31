import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	class File {
		private String fileName;
		private String head;
		private String number;

		public File(String fileName, String head, String number) {
			this.fileName = fileName;
			this.head = head;
			this.number = number;
		}
	}

	public List<String> solution(String[] files) {
		List<File> fileList = new ArrayList<>();
		for (String file : files) {
			fileList.add(splitFileName(file));
		}

		fileList.sort(new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				if (o1.head.equalsIgnoreCase(o2.head)) {
					return (int) (Long.parseLong(o1.number) - Long.parseLong(o2.number));
				}
				return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
			}
		});

		return fileList.stream().map(file -> file.fileName).collect(Collectors.toList());
	}

	private File splitFileName(String paramFile) {
		int numberIdx = 0;
		int tailIdx = paramFile.length();
		for (int i = 0; i < paramFile.length(); i++) {
			if (numberIdx == 0 && Character.isDigit(paramFile.charAt(i))) {
				numberIdx = i;
			}

			if (numberIdx > 0 && !Character.isDigit(paramFile.charAt(i))) {
				tailIdx = i;
				break;
			}
		}
		String head = paramFile.substring(0, numberIdx);
		String number = paramFile.substring(numberIdx, Math.min(tailIdx, numberIdx + 5));

		return new File(paramFile, head, number);
	}
}