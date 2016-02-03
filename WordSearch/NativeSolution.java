package WordSearch;

public class NativeSolution {
	public boolean exist(char[][] board, String word) {
		if(board.length == 0  ) {
			return false;
		}
		
		int rowLen = board.length;
		int colLen = board[0].length;
		boolean[][] isVisited = new boolean[rowLen][colLen];
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {
				
				isVisited[i][j] = true;
				boolean match = isMatch(board, word, isVisited, i, j, 0, rowLen, colLen);
				if(match) {
					return true;
				}
				isVisited[i][j] = false;
			}
		}
		return false;
	}
	
	public boolean isMatch(char[][] board, String word, boolean[][] isVisited, int row, int col, int currLen, int rowLen, int colLen) {
		

		if(currLen >= word.length()) {
			return false;
		}
		char letter = word.charAt(currLen);
		if(letter != board[row][col]) {
			return false;
		} 
		//System.out.println()
		if(letter == board[row][col] && currLen == word.length() - 1) {
			return true;
		} 
		
		if(row - 1 >= 0 && !isVisited[row - 1][col]) {
			isVisited[row - 1][col] = true;
			 boolean up =  isMatch(board, word, isVisited, row - 1, col, currLen + 1, rowLen, colLen);
			 isVisited[row - 1][col] = false;
			 if(up) return true;
		}
		
		if(row + 1 < rowLen && !isVisited[row + 1][col]) {
			isVisited[row + 1][col] = true;
			 boolean down =  isMatch(board, word, isVisited, row + 1, col, currLen + 1, rowLen, colLen);
			 isVisited[row + 1][col] = false;
			 if(down) return true;
		}
		
		if(col - 1 >= 0 && !isVisited[row][col - 1]) {
			isVisited[row][col - 1] = true;
			 boolean left =  isMatch(board, word, isVisited, row, col - 1, currLen + 1, rowLen, colLen);
			 isVisited[row][col - 1]  = false;
			 if(left) return true;
		}
		
		if(col + 1 < colLen && !isVisited[row][col + 1]) {
			isVisited[row][col + 1] = true;
			 boolean right =  isMatch(board, word, isVisited, row, col + 1, currLen + 1, rowLen, colLen);
			 isVisited[row][col + 1] = false;
			 if(right) return true;
		}
		return false;
		
		
	}
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		NativeSolution wordSearch =new NativeSolution();
		System.out.println(board[0][0]);
		System.out.println(board[0][3]);
		System.out.println(wordSearch.exist(board, "ABCCED"));
	}

}
