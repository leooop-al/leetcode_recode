package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution.java, v 0.1 2022年06月01日 17:10 ziyou.cxf Exp $
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
