package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution122.java, v 0.1 2022年07月10日 9:33 ziyou.cxf Exp $
 * @desc : dynamic programming
 */
public class Solution122 {

    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        int i = solution122.maxProfit(new int[]{1,2,3,4,5});
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        return dp(prices);
    }

    private int dp(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
