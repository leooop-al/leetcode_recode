package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution48.java, v 0.1 2022年05月01日 17:45 ziyou.cxf Exp $
 */
public class Solution48 {

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        solution48.rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            rotate(matrix, i);
        }
    }

    private void rotate(int[][] matrix, int step) {
        int n = matrix.length;
        for (int i = step; i < n - step-1; i++) {
            int tmp1 = matrix[i][n - 1 - step];
            matrix[i][n - 1 - step] = matrix[step][i];

            int tmp2 = matrix[n - 1- step][n - 1 - i];
            matrix[n - 1 - step][n - 1 - i] = tmp1;

            int tmp3 = matrix[n - 1 - i][step];
            matrix[n - 1 - i][step] = tmp2;

            matrix[step][i] = tmp3;
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int tmp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }
}
