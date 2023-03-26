package 모의고사8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {

	/*
	0. 득점 표를 만든다.
	1. 0의 개수를 센다.
	2. 당첨 번호와 고른 번호의 교집합을 구한다. -> 둘 다 리스트로 치환
	3. 교집합 + 0의 개수 -> 최고 득점, 교집합 -> 최저 득점
	*/

	Map<Integer, Integer> winMap
		= Map.of(6,1,5,2,4,3,3,4,2,5,1,6,0, 6);

	public int[] solution(int[] lottos, int[] winNums) {
		List<Integer> lottoList = new ArrayList<>();
		List<Integer> winNumList = new ArrayList<>();

		int zeroCnt = countZero(lottos);

		// 리스트화 하기
		for (int i = 0; i < 6; i++) {
			lottoList.add(lottos[i]);
			winNumList.add(winNums[i]);
		}

		lottoList.retainAll(winNumList);

		int winCnt = lottoList.size();

		int maxWin = winMap.get(winCnt) + zeroCnt;
		int minWin = winMap.get(winCnt);

		return new int[] {maxWin, minWin};
	}

	private int countZero(int[] lottos) {
		int zeroCnt = 0;
		for (int num : lottos) {
			if (num == 0) {
				zeroCnt++;
			}
		}
		return zeroCnt;
	}
}
