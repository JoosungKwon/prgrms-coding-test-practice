package 모의고사6;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int[] solution(int[] numbers) {
		Set<Integer> resultSet = new HashSet<>();
		int len = numbers.length;

		for(int i = 0; i < len; i++) {
			for(int j = i + 1; j < len; j++) {
				resultSet.add(numbers[i] + numbers[j]);
			}
		}
		return resultSet.stream().mapToInt(i -> i).sorted().toArray();
	}
}
