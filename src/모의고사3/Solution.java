package 모의고사3;

class Solution {

	/*
	 왼쪽에서 오른쪽 숫자로 순회하면서
	 약수의 개수를 센다
	 약수의 개수가 홀수면 빼고 짝수면 더한다.
	 약수의 개수는 나머지가 0인 경우를 카운트 하여 센다.
	*/

	public int solution(int left, int right) {
		int result = 0;

		for(int n = left; n <= right; n++) {
			int divisor = countDivisor(n);

			if (divisor % 2 == 0 ) {
				result = result + n;
			} else {
				result = result - n;
			}
		}

		return result;
	}

	private int countDivisor(int num) {
		int cnt = 0;

		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				cnt ++;
			}
		}

		return cnt;

	}
}