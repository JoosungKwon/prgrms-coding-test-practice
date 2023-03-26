package 모의고사6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;

class Solution3 {

	ArrayList<Integer> table = new ArrayList<>();
	ArrayDeque<int[]> deleteQuery = new ArrayDeque<>();

	public static void main(String[] args) {

		Solution3 sol1 = new Solution3();
		Solution3 sol2 = new Solution3();

		int n = 8;
		int k = 2;
		String[] cmd1 = new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
		String[] cmd2 = new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};

		String result = sol1.solution(n, k, cmd1);
		String result2 = sol2.solution(n, k, cmd2);

		System.out.println(result + ":" + Objects.equals(result, "OOOOXOOO"));
		System.out.println(result2 + ":" + Objects.equals(result2, "OOXOXOOO"));
	}

	public String solution(int n, int k, String[] cmds) {
		// 원래 행 번호 설정
		for (int i = 0; i < n; i++) {
			table.add(i);
		}

		// 현재 행
		int currentRow = k;

		// 명령을 수행
		for(String cmd : cmds) {
			String[] command = cmd.split(" ");
			String action = command[0];
			switch (action) {
				case "U" -> currentRow -= Integer.parseInt(command[1]);
				case "D" -> currentRow += Integer.parseInt(command[1]);
				case "C" -> currentRow = delete(currentRow);
				case "Z" -> currentRow = rollback(currentRow); // 현재 행을 유지하기 위해서는 반대로 변경된 테이블에 맞게 위치를 조절해야함
			}
		}

		StringBuilder result = new StringBuilder("X".repeat(n));
		// 남아 있는 원래 행은 "O"로 치환
		for (int row : table) {
			result.replace(row, row + 1, "O");
		}

		return result.toString();
	}

	private int rollback(int currentRow) {
		int[] query = deleteQuery.pop();
		table.add(query[0], query[1]);

		if (query[0] <= currentRow) { // 현재 행 보다 밑에 새로운 행이 추가되면 + 1를 해줌으로서 현 위치 유지
			return currentRow + 1;
		}
		return currentRow;
	}

	private int delete(int currentRow) {
		deleteQuery.push(new int[]{currentRow, table.get(currentRow)});
		table.remove(currentRow);

		if (currentRow == table.size()) {
			return currentRow - 1;
		}

		return currentRow;
	}

}
