package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution62.java, v 0.1 2022年05月25日 20:28 ziyou.cxf Exp $
 */
public class Solution62 {

    public static void main(String[] args) {
        int ans = new Solution62().uniquePaths(3, 7);
        System.out.println(ans);
    }

    public int uniquePaths(int m, int n) {
        int[][] arry = new int[m][n];
        for (int i = 0; i < m; i++) {
            arry[i][0]= 1;
        }
        for (int i = 0; i < n; i++) {
            arry[0][i]= 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arry[i][j] = arry[i-1][j] + arry[i][j-1];
            }
        }
        return arry[m - 1][n - 1];
    }

}
