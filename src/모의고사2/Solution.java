package 모의고사2;

class Solution {
	// 가격이 계속 n배로 증가
	// n + 2n + 3n -> n(1+2+3..) -> n * ((n*n+1)/2)
	// 예상 가격 - 현재 금액
	public long solution(long price, long money, long count) {

		long result = price * ((count * (count + 1)) / 2) - money;

		return result > 0 ? result : 0;
	}
}