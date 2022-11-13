package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution221.java, v 0.1 2022年08月07日 12:39 ziyou.cxf Exp $
 * @desc : 最大正方形
 */
public class Solution221 {

    public static void main(String[] args) {
        Solution221 solution221 = new Solution221();
        int i = solution221.maximalSquare(new char[][]{
                {'1', '0'}
        });

        System.out.println(i);
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0] - '0';
            if (max == 0) {
                max = dp[i][0] == 1 ? 1 : 0;
            }
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i] - '0';
            if (max == 0) {
                max = dp[i][0] == 1 ? 1 : 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
