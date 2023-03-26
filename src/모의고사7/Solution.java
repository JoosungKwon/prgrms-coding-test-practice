package 모의고사7;

import java.util.ArrayList;
import java.util.List;

class Solution {

	/*
	 x, y로 주어지는 점들은 총 3개
	 그 중 두개는 동일하고 1는 다름
	 다른 1가 찾고자하는 점의 x,y
	*/

	public int[] solution(int[][] v) {
		int x = findOtherOne(v, 0);
		int y = findOtherOne(v, 1);

		return new int[]{x,y};
	}

	private int findOtherOne(int[][] table, int index) {
		List<Integer> points = new ArrayList<>();

		for (int[] ints : table) {
			int point = ints[index];

			if (points.contains(point)) {
				points.remove(Integer.valueOf(point));
			} else {
				points.add(point);
			}
		}
		return points.get(0);
	}
}