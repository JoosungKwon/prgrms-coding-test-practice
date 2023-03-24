package 모의고사5;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution2 {

	Map<String, String> convertMap
		= Map.of("A", "E", "E", "I", "I", "O", "O", "U");

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int result = sol.solution("I");
		System.out.println(result);
	}

	public int solution(String word) {

		Map<String, Integer> resultSet = new HashMap<>();
		StringBuilder target = new StringBuilder("A");
		int cnt = 1;

		// 미리 모든 경우에 해당하는 단어와 단어가 등장하는 숫자를 mapping
		while(!Objects.equals("UUUUU", target.toString())) {

			if(target.length() < 5) {
				target.append("A");
			} else {

				int lastPoint = target.length() - 1;
				String lastWord = target.substring(lastPoint, lastPoint + 1);

				if(Objects.equals(lastWord, "U")) {
					deleteLastWord(target);
					String nextWord = convertMap.get(target.substring(target.length() - 1, target.length()));
					target.replace(target.length() - 1, target.length(), nextWord);
				} else {
					String nextWord = convertMap.get(lastWord);
					target.replace(lastPoint, lastPoint + 1, nextWord);
				}
			}

			resultSet.put(target.toString(), ++cnt);
		}

		return resultSet.get(word);
	}

	private void deleteLastWord(StringBuilder target) {
		int len = target.length();

		if (Objects.equals("U".repeat(len), target.toString())) {
			return;
		}

		int lastPoint = target.length() - 1;
		target.delete(lastPoint, lastPoint + 1);
		String lastWord = target.substring(target.length() - 1, target.length());

		if(Objects.equals("U", lastWord)){
			deleteLastWord(target);
		}
	}
}
