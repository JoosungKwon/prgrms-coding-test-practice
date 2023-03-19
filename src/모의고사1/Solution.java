package 모의고사1;

import java.util.*;

class Solution {
	public boolean solution(int[] arr) {
		Set<Integer> countSet = new HashSet<>();
		int n = arr.length;

		// 숫자가 등장하면 Set 자료구조에 담는 방식
		// 배열을 순회하면서 존재하지 않는 경우 하나씩 집어 넣는다.
		// 이 때, 배열의 길이를 넘어가는 숫자가 등장하거나(n이상의 값)
		// 집합에 이미 존재하는 경우
		// false를 리턴한다.
		// 모든 배열을 순회한 후에
		// 집합의 크기가 n인 경우 true
		// 아닌 경우 false를 리턴한다.

		for (int num : arr) {
			if (num > n || countSet.contains(num)) {
				return false;
			}
			countSet.add(num);
		}

		return countSet.size() == n;
	}
}