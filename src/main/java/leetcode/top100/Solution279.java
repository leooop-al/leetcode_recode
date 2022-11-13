package leetcode.top100;

import java.util.Arrays;

/**
 * @author ziyou.cxf
 * @version : Solution279.java, v 0.1 2022年08月10日 22:04 ziyou.cxf Exp $
 * @desc : 完全平方数
 */
public class Solution279 {

    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        System.out.println(solution279.numSquares(13));
    }

    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        Arrays.fill(nums, n);
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                nums[i] = Math.min(nums[i], nums[i - j * j] + 1);
            }
        }
        return nums[n];
    }
}
