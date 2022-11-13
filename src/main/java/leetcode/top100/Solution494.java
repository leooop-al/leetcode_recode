package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution494.java, v 0.1 2022年08月20日 20:55 ziyou.cxf Exp $
 */
public class Solution494 {

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        //  return dsf(nums, 0, 0, target);
        return dp(nums, target);
    }

    private static int dp(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum < target) {
            return 0;
        }

        int t = 2 * sum + 1;
        int[][] dp = new int[nums.length][t];
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = sum; j < t; j++) {
                if (j - nums[i] > 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] < t) {
                    dp[i][j] += dp[i - 1][j + nums[i]];

                }
            }
        }
        return dp[nums.length - 1][target+sum];
    }

    private static int dsf(int[] nums, int index, int cur, int target) {
        if (index == nums.length && cur == target) {
            return 1;
        }
        if (index == nums.length) {
            return 0;
        }

        int result = 0;
        result += dsf(nums, index + 1, cur + nums[index], target);
        result += dsf(nums, index + 1, cur - nums[index], target);
        return result;
    }
}
