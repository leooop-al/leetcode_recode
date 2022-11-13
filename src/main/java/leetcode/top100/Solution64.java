package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution64.java, v 0.1 2022年06月01日 16:58 ziyou.cxf Exp $
 */
public class Solution64 {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        Solution64 solution64 = new Solution64();
        int i = solution64.minPathSum(grid);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i-1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
