package Search2dMatrix2;

/**
 * Created by linyupeng on 9/20/15.
 */
public class Search2dMatrix2 {
    /*see cracking the coding interview*/
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;
        int row = matrix.length;
        int col = matrix[0].length;
        while(x < row && y >= 0) {
            if(matrix[x][y] == target) {
                return true;
            } else if(target < matrix[x][y]) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
