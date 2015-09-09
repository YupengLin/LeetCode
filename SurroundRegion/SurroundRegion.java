package SurroundRegion;

import java.util.ArrayList;

/**
 * Created by linyupeng on 9/8/15.
 */
public class SurroundRegion {
    public static void solve(char[][] board) {
        if(board.length <= 2 || board[0].length <= 2) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] isVisited = new boolean[row][col];
        for(int i = 1; i < board.length - 2; i++){
            for(int j = 1; j < board[0].length - 2; j++) {
                if(board[i][j] == 'X') {
                    continue;
                }
                if(board[i][j] == 'O' && !isVisited[i][j]) {
                    ArrayList<Integer> x = new ArrayList<>();
                    ArrayList<Integer> y = new ArrayList<>();
                    dfs(row, col, i, j, board, isVisited, x, y);
                    System.out.println( "x size = " + x.size());
                    System.out.println( "y size = " + y.size());
                    if(x.size() != 0) {
                        for(int k = 0; k < x.size(); k++){
                            int xRow = x.get(k);
                            int yCol = y.get(k);
                            System.out.println("x = " + xRow + "y = " + yCol);
                            board[xRow][yCol] = 'X';
                        }
                    }
                }

            }
        }


    }

    public static void dfs(int row, int col, int i, int j, char[][] board, boolean[][] isVisited, ArrayList<Integer> x, ArrayList<Integer> y) {
        isVisited[i][j] = true;
        x.add(new Integer(i));
        y.add(new Integer(j));

        if((i == 1 && board[i - 1][j] == 'O') || (j == 1 && board[i][j - 1] == 'O')) {
            x.clear();
            y.clear();
            return;
        }
        if((i == row - 2 && board[i + 1][j] == 'O') || (j == col -2 && board[i][j + 1] =='O')) {
            x.clear();
            y.clear();
            return;
        }


        if(board[i][j + 1] == 'O' && !isVisited[i][j + 1]) {
            dfs(row, col, i, j + 1, board, isVisited, x, y);
        }
        if(board[i + 1][j] == 'O' && !isVisited[i + 1][j]) {
            dfs(row, col, i + 1, j, board, isVisited, x, y);
        }
        if(board[i][j - 1] == 'O' && !isVisited[i][j - 1]) {
            dfs(row, col, i, j - 1, board, isVisited, x, y);
        }
        if(board[i - 1][j] == 'O' && !isVisited[i - 1][j]) {
            dfs(row, col, i - 1, j, board, isVisited, x, y);
        }


    }





    public static void main(String[] args) {
        char [][] board = {{'O', 'X', 'X', 'O','X'},
                            {'X', 'O', 'O', 'X','O'},
                            {'X', 'O', 'X', 'O','X'},
                            {'O', 'X', 'O', 'O', 'O'},
                            {'X','X','O','X','O'}};


        solve(board);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
