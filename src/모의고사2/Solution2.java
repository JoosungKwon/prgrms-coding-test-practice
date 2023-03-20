package 모의고사2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {

	// 공식을 통해 겹친는 교점("*")을 찾는다.
	// 교점에서 가장 멀리 떨어진(max) 두 곳(x, y)을 찾아 그림(".")을 그린다.
	// 그림에서 겹치는 부위(점)을 "*"로 치환한다.

	public static void main(String[] args) {

		int[][] line = 	new int[][] {
			{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
		};

		int[][] line2 = 	new int[][] {
			{0, 1, -1}, {1, 0, -1}, {1, 0, 1}
		};

		int[][] line3 = 	new int[][] {
			{0,0,0}, {0,0,0}
		};

		Solution2 test = new Solution2();
		String[] result = test.solution(line3);

		Arrays.stream(result).forEach(System.out::println);
	}

	public String[] solution(int[][] line) {

		int[][] intersectionPoint = findIntersectionPoint(line);

		return drwaIntersectionPointInGrid(intersectionPoint);
	}

	private int[][] findIntersectionPoint(int[][] lines) {
		ArrayList<int[]> intersectionPoint = new ArrayList<>();

		for (int i = 0; i < lines.length; i++) {
			for(int j = i + 1; j < lines.length; j++) {
				int A = lines[i][0];
				int B = lines[i][1];
				int E = lines[i][2];
				int C = lines[j][0];
				int D = lines[j][1];
				int F = lines[j][2];

				if (A*D - B*C == 0) {
					continue;
				}

				double x = ((B*F) - (E*D)) / (double)((A*D) - (B*C));
				double y = ((E*C) - (A*F)) / (double)((A*D) - (B*C));

				if (!(isInteger(x) && isInteger(y))) {
					continue;
				}

				int[] point = new int[]{(int)x,(int)y};

				intersectionPoint.add(point);
			}
		}

		return intersectionPoint.toArray(int[][] :: new);
	}

	private boolean isInteger(double num) {
		return num == (int) num;
	}

	private String[] drwaIntersectionPointInGrid(int[][] points) {

		int maxX = points[0][0];
		int minX = points[0][0];
		int maxY = points[0][1];
		int minY = points[0][1];

		for (int[] point : points) {
			maxX = Math.max(maxX, point[0]);
			minX = Math.min(minX, point[0]);
			maxY = Math.max(maxY, point[1]);
			minY = Math.min(minY, point[1]);
		}

		List<StringBuilder> gridList = new ArrayList<>();

		for (int i = minY; i <= maxY; i++) {
			StringBuilder line = new StringBuilder();
			for (int j = minX; j <= maxX; j++) {
				if (checkPoint(j,i, points)) {
					line.append("*");
				} else {
					line.append(".");
				}
			}

			gridList.add(line);
		}

		String[] drawnGrid = new String[gridList.size()];

		for (int i = 0; i < gridList.size(); i++) {
			drawnGrid[i] = gridList.get(gridList.size() - 1 - i).toString();
		}

		return drawnGrid;
	}

	private boolean checkPoint(int x, int y, int[][] points) {

		for (int[] point : points) {
			if(x == point[0] && y == point[1]){
				return true;
			}
		}
		return false;
	}

}