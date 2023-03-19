package 모의고사1;

class Solution2 {
	public int solution(int[][] sizes) {

		// 가로와 세로를 비교해서 큰 쪽을 가로에 둔다.
		// 그렇게 되면 가로는 큰 값들만 세로는 작은값들만 모이게 된다.
		// 큰 값중 최대값과 작은 값들 중 최대값을 곱한 값이 최소 크기가 된다.
		int maxWidth = 0;
		int maxLength = 0;

		for (int[] size : sizes) {
			int width = Math.max(size[0],size[1]);
			int length = Math.min(size[0],size[1]);
			maxWidth = Math.max(maxWidth, width);
			maxLength = Math.max(maxLength, length);
		}

		return maxWidth * maxLength;
	}
}