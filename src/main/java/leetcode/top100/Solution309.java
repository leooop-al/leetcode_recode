package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution309.java, v 0.1 2022年08月13日 16:47 ziyou.cxf Exp $
 */
public class Solution309 {

    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        System.out.println(solution309.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0]; // 手上持有股票的最大收益
        dp[0][1] = 0; // 手上不持有股票，并且在冷冻期中的累计最大收益
        dp[0][2] = 0; // 手上不持有股票，并且不在冷冻期中的累计最大收益
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
