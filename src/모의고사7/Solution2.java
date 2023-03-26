package 모의고사7;

class Solution2 {

	/*
	문자열이 "1"이 될 때 까지
	0을 제거 후 다시 10진법 숫자로 변환
	 */

	public int[] solution(String s) {
		int[] answer = new int[2];
		int cnt = 0 ;
		int zeroCnt = 0;
		// s가 1이 될때 까지
		while(!"1".equals(s)){
			int originLen = s.length(); // 원래 길이
			s = s.replace("0","");
			int afterLen = s.length(); // 0을 제거하고 난 뒤 길이
			zeroCnt += originLen - afterLen;
			s = Integer.toBinaryString(afterLen);
			cnt++;
		}
		answer[0] = cnt;
		answer[1] = zeroCnt;
		return answer;
	}
}