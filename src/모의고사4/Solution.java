package 모의고사4;

class Solution {

    /*
     단순 구현 문제
     n의 크기 만큼 순회하면서 내적 공식에 맞게 값을 도출하면 된다.
    */

	public int solution(int[] a, int[] b) {
		int answer = 0;
		int n = a.length;

		for(int i = 0; i < n; i++) {
			answer = answer + (a[i] * b[i]);
		}

		return answer;
	}
}
