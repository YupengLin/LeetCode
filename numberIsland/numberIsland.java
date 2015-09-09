package numberIsland;

/**
 * Created by linyupeng on 9/7/15.
 */
public class numberIsland {
    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '0') {
                    continue;
                } else {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static  void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0') {
            return;
        }
        //if(grid[i][j] == '1') {
            grid[i][j] = '0';
       // }
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','0'}};
        System.out.println(grid.length);
        System.out.println(grid[0].length);
        System.out.println(numIslands(grid));
    }
}
