package 모의고사6;

import java.util.ArrayDeque;
import java.util.Objects;

class Solution4 {

	int[] table;
	ArrayDeque<Integer> deleteQuery = new ArrayDeque<>();

	public static void main(String[] args) {

		Solution4 sol1 = new Solution4();
		Solution4 sol2 = new Solution4();

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

		table = new int[n];

		// 현재 행
		int currentRow = k;

		// 명령을 수행
		for(String cmd : cmds) {
			String[] command = cmd.split(" ");
			String action = command[0];
			switch (action) {
				case "U", "D" -> {
					int x = Integer.parseInt(command[1]);
					currentRow = move(action, x, currentRow);
				}
				case "C" -> currentRow = delete(currentRow);
				case "Z" -> rollback();
			}
		}

		StringBuilder result = new StringBuilder();
		// -1 인 행은 삭제된 행이기 때문에 X 처리
		for (int row : table) {
			String ox = "X";
			if (row != -1) {
				ox = "O";
			}
			result.append(ox);
		}

		return result.toString();
	}

	private int move(String action, int x, int currentRow) {

		// up -> -1, down 1 => 방향 설정
		int operator = -1;
		if (Objects.equals(action, "D")) {
			operator = 1;
		}
		// 방향으로 이동하면서 비어 있는 칸은 점프
		for (int i = 0; i < x; i++) {
			int next = currentRow + operator;
			while (table[next] == -1) {
				next += operator;
			}
			currentRow = next;
		}

		return currentRow;
	}

	private void rollback() {
		int row = deleteQuery.pop();
		table[row] = 0;
	}

	private int delete(int currentRow) {
		String action = "D";

		if (isLast(currentRow)) {
			action = "U";
		}

		deleteQuery.push(currentRow);
		table[currentRow] = -1;
		return move(action, 1, currentRow);
	}

	private boolean isLast(int currentRow) {
		int index = table.length - 1;

		while (table[index] == -1) {
			index--;
		}

		return currentRow == index;
	}

}
