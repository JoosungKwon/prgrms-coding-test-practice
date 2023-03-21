package 모의고사3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {

	/*
	주어지는 노드의 연결을 하나씩 제거하고 쪼개진 네트워크의 개수를 세어서
	적어진 네트워크가 최대가 되는 경우의 수를 리턴한다.
	 */

	public static void main(String[] args) {

		Solution2 sol = new Solution2();

		int[][] case1 = new int[][]{{1, 2}, {2, 3}, {3, 4}};
		int n1 = 4;

		int[][] case2 = new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
		int n2 = 7;

		int result1 = sol.solution(n1, case1);
		int result2 = sol.solution(n2, case2);

		System.out.println(result1);
		System.out.println(result2);

	}


	public int solution(int n, int[][] wires) {

		int minNetworkDif = n;

		for (int i = 0; i < wires.length; i++) {

			int node1 = wires[i][0];
			int node2 = wires[i][1];

			List<Set<Integer>> graphs = new ArrayList<>();

			for (int t = 0; t < n; t++) {
				graphs.add(new HashSet<>());
			}

			for (int j = 0; j < wires.length; j++) {
				if (i == j) {
					continue;
				}
				int nodeA = wires[j][0];
				int nodeB = wires[j][1];
				graphs.get(nodeA-1).add(nodeB);
				graphs.get(nodeB-1).add(nodeA);
			}

			for (int nodeNum : new HashSet<>(graphs.get(node1 - 1))) {
				treeTracking(graphs, nodeNum, node1);
			}

			for (int nodeNum : new HashSet<>(graphs.get(node2 - 1))) {
				treeTracking(graphs, nodeNum, node2);
			}

			int node1Cnt = graphs.get(node1 - 1).size();
			int node2Cnt = graphs.get(node2 - 1).size();


			int dif = Math.abs(node1Cnt - node2Cnt);

			minNetworkDif = Math.min(dif,minNetworkDif);
		}

		return minNetworkDif;
	}

	private void treeTracking(List<Set<Integer>> graphs, int node, int rootNode) {

		for (int nodeNum : graphs.get(node - 1)) {
			if (graphs.get(rootNode - 1).contains(nodeNum)) {
				continue;
			}
			if (rootNode == nodeNum) {
				continue;
			}
			graphs.get(rootNode - 1).add(nodeNum);
			treeTracking(graphs, nodeNum, rootNode);
		}
	}

}
