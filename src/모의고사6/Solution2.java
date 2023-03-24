package 모의고사6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution2 {

	/*
	1.k진법으로 만들기
	2.0을 기준으로 쪼개기
	3.쪼갠 값이 소수이면 add
	*/

	public static void main(String[] args) {
		Solution2 sol = new Solution2();

		int n1 = 437674;
		int k1 = 3;
		int result1 = sol.solution(n1, k1);

		int n2 = 333333333;
		int k2 = 3;
		int result2 = sol.solution(n2, k2);

		System.out.println(result1);
		System.out.println(result2);
	}

	public int solution(int n, int k) {
		List<String> resultList = new ArrayList<>();
		String notationK = toNotation(n, k);
		String[] candidateNumbers = notationK.split("0");

		for(String number : candidateNumbers) {
			boolean result = isPrimaryNumber(number);
			if (result) {
				resultList.add(number);
			}
		}

		return resultList.size();
	}

	private boolean isPrimaryNumber(String number) {
		if(Objects.isNull(number)|| number.isBlank() || Objects.equals(number, "1")) {
			return false;
		}

		long num = Long.parseLong(number);

		for (int i = 2; i < (int) Math.pow(num, 0.5) + 1; i++) {
			if ((num % i) == 0) {
				return false;
			}
		}

		return true;
	}

	private String toNotation(int n, int k) {
		StringBuilder result = new StringBuilder();

		while(n > k) {
			result.append(Math.floorMod(n,k));
			n =  Math.floorDiv(n,k);
		}
		result.append(Math.floorMod(n,k));
		return result.reverse().toString();
	}
}
