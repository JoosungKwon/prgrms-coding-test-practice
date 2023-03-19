package 모의고사1;

import java.util.Stack;

class Solution3 {

	public static void main(String[] args) {
		var test = new Solution3();

		String number = "4177252841";
		int k = 4;

		test.solution(number, k);
	}

	public String solution(String number, int k) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder answer = new StringBuilder();
		String[] numberArray = number.split("");
		int numberLen = numberArray.length;
		int delCount = 0;

		// 스택을 이용해 앞에서 부터 값을 거꾸로 쌓는다.
		// 다음 들어오려는 값이 현재 맨 위 값보다 크다면 삭제하고 집어 넣는다
		// 아닌 경우 그냥 쌓는다.
		// 삭제시에 카운트를 증가하고 k가 채워진 경우 남은 숫자와 지금 까지 스택에 쌓인 값을 넣는다.
		// 만약, 다 쌓았는데 카운트가 채워지지 못한 경우 스택에서 남은 k만큼 위에서 제거한다.

		for (int i = 0; i < numberLen; i++) {
			int num = Integer.parseInt(numberArray[i]);

			while (!stack.isEmpty() && delCount != k && stack.peek() < num) { // 다음 들어오려는 값이 현재 맨 위 값보다 크다면 삭제한다.
				stack.pop();
				delCount++;
			}

			stack.push(num);

			if (delCount == k) {
				i++;// k가 채워진 경우 남은 숫자를 스택에 다 담는다.
				while(i < numberLen) {
					int remainNum = Integer.parseInt(numberArray[i]);
					stack.push(remainNum);
					i++;
				}
				break;
			}
		}

		while(k - delCount != 0) {
			delCount++;
			stack.pop();
		}

		for (int num : stack) {
			answer.append(num);
		}


		return answer.toString();
	}
}
