package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution200.java, v 0.1 2022年07月29日 8:10 ziyou.cxf Exp $
 */
public class Solution200 {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    deepSearch(grid, i, j);
                }
            }
        }
        return count;
    }

    private void deepSearch(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return;
        }
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        deepSearch(grid, i + 1, j);
        deepSearch(grid, i - 1, j);
        deepSearch(grid, i, j + 1);
        deepSearch(grid, i, j - 1);
    }
}
