package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution647.java, v 0.1 2022年08月24日 23:05 ziyou.cxf Exp $
 */
public class Solution647 {

    public static void main(String[] args) {
        countSubstrings("aabbaa");
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }

        int count = dp.length;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }

}
