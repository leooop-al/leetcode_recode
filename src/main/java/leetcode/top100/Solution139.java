package leetcode.top100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ziyou.cxf
 * @version : Solution139.java, v 0.1 2022年07月17日 11:19 ziyou.cxf Exp $
 */
public class Solution139 {

    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> maps = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <i; j++) {
                if (dp[j] && maps.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
