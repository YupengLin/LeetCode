package GameOfLife;

public class NativeSolution {
	public void gameOfLife(int[][] board) {
		if(board.length == 0 || board[0].length == 0) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				int liveNeighbor = getLiveNeighbor(board, i, j);
				int currStat = board[i][j] & 1;
				if(currStat == 1) {
					if(liveNeighbor < 2) {
						board[i][j] = 1;  //01
					} else if(liveNeighbor == 2 || liveNeighbor == 3) {
						board[i][j] = 3; // 11
					} else {
						board[i][j] = 1;
					}
				} else {
					if(liveNeighbor == 3) {
						board[i][j] = 2; //10
					}
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = ((board[i][j] & 2) == 0) ? 0 : 1;
			}
		}
		
	}

	private int getLiveNeighbor(int[][] board, int row, int col) {
		int m = board.length;
		int n = board[0].length;
		int rowLower = Math.max(0, row - 1);
		int rowUpper = Math.min(m - 1, row + 1);
		int colLower = Math.max(0, col - 1);
		int colUpper = Math.min(n - 1, col + 1);
		int liveNeighbor = 0;
		System.out.println("====");
		for(int i = rowLower; i <= rowUpper; i++) {
			for(int j = colLower; j <= colUpper; j++) {
				if(!(i == row && j == col)) {
					liveNeighbor += board[i][j] & 1;
				} 
			}
		}
		return liveNeighbor;
	}
	
	public static void main(String[] args) {
		int[][] live = {{1,1}, {1,0}, {0,0}};
		
		NativeSolution game = new NativeSolution();
		game.gameOfLife(live);
		
 	}
}
