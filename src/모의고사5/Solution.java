package 모의고사5;

import java.util.ArrayList;

class Solution {

	ArrayList<Integer> threeNotation = new ArrayList<>();

	public int solution(int n) {
		int answer = 0;
		// 나눈 값이 0이 될 때까지 나머지를 리스트에 add
		while (n / 3 > 0) {
			n = transNotation(n);
		}
		// 만약 나머지가 0이 아닌 경우 -> 한번 더 add해준다.
		if (n % 3 != 0){
			transNotation(n);
		}
		// 3 ^ (리스트의 사이즈 - 1-i) * 리스트[i]를 더해준다
		// -> -1를 하는 이유: 0 제곱 부터 시작해야 함으로
		for (int i = 0; i < threeNotation.size(); i++) {
			// pow -> double 리턴함으로 int 형변환 필요
			answer += (int) Math.pow(3, threeNotation.size() - 1 - i) * threeNotation.get(i);
		}

		return answer;
	}

	private int transNotation(int n) {
		threeNotation.add(n % 3);
		return n / 3;
	}

}

