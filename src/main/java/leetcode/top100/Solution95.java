package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution95.java, v 0.1 2022年06月30日 9:16 ziyou.cxf Exp $
 * @desc: 动态规划
 */
public class Solution95 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
