package DailyQuestions;

public class SlidingPuzzle {

	public int slidingPuzzle(int[][] board) {
		int[] dr = {0, 1, 0, -1};
		int[] dc = {-1, 0, 1, 0};

		int[][] target = {{1, 2, 3}, {4, 5, 0}};
		int r = 0, c = 0;

		// Find position of empty cell (0)
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					r = i;
					c = j;
					break;
				}
			}
		}

		// BFS setup
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c, board, 0));
		Set<String> visited = new HashSet<>();
		visited.add(Arrays.deepToString(board));

		// BFS loop
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			int row = current.row;
			int col = current.col;
			int[][] state = current.board;
			int steps = current.steps;

			if (Arrays.deepEquals(state, target)) return steps;

			// Explore neighbors
			for (int i = 0; i < 4; i++) {
				int newRow = row + dr[i];
				int newCol = col + dc[i];
				if (newRow >= 0 && newRow < 2 && newCol >= 0 && newCol < 3) {
					int[][] newBoard = deepCopy(state);
					swap(newBoard, row, col, newRow, newCol);
					String boardStr = Arrays.deepToString(newBoard);
					if (!visited.contains(boardStr)) {
						queue.offer(new Node(newRow, newCol, newBoard, steps + 1));
						visited.add(boardStr);
					}
				}
			}
		}

		return -1;
	}

	private void swap(int[][] board, int x1, int y1, int x2, int y2) {
		int temp = board[x1][y1];
		board[x1][y1] = board[x2][y2];
		board[x2][y2] = temp;
	}

	private int[][] deepCopy(int[][] board) {
		int[][] copy = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			copy[i] = board[i].clone();
		}
		return copy;
	}

	static class Node {
		int row, col, steps;
		int[][] board;

		Node(int row, int col, int[][] board, int steps) {
			this.row = row;
			this.col = col;
			this.board = board.clone();
			this.steps = steps;
		}
	}
}
