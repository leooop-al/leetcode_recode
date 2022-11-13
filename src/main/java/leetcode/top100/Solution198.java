package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution198.java, v 0.1 2022年07月28日 22:02 ziyou.cxf Exp $
 * @desc : 打家劫舍，动态规划
 */
public class Solution198 {

    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        System.out.println(solution198.rob(new int[]{2,7,9,3,1}));
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
