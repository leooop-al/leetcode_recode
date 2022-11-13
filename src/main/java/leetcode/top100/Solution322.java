package leetcode.top100;

import java.util.Arrays;

/**
 * @author ziyou.cxf
 * @version : Solution322.java, v 0.1 2022年08月14日 9:41 ziyou.cxf Exp $
 */
public class Solution322 {

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        System.out.println(solution322.coinChange(new int[]{2}, 3));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j<coins.length && coins[j] <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
            }
        }
        return dp[amount] == (amount+1) ? -1 : dp[amount];
    }
}
