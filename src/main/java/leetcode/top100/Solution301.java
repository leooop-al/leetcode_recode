package leetcode.top100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ziyou.cxf
 * @version : Solution301.java, v 0.1 2022年08月13日 11:19 ziyou.cxf Exp $
 */
public class Solution301 {

    public static void main(String[] args) {
        Solution301 solution301 = new Solution301();
        List<String> sets = solution301.removeInvalidParentheses("()(a))()");
        System.out.println(sets);
    }

    private Set<String> set = new HashSet<>();

    private int n, max, maxLen;

    private String s;

    public List<String> removeInvalidParentheses(String _s) {
        this.s = _s;
        n = s.length();

        int l = 0,
        r = 0;

        for (char c : _s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                r++;
            }
        }

        max = Math.min(l, r);

        dfs(0, "", 0);
        return new ArrayList<>(set);
    }

    private void dfs(int point, String cur, int score) {
        if (score < 0 ) {
            return;
        }
        if (point == n) {
            if (score == 0 && cur.length() >= maxLen) {
                if (cur.length() > maxLen) {
                    set.clear();
                }
                maxLen = cur.length();
                set.add(cur);
            }
            return;
        }
        char c = s.charAt(point);
        if (c == '(') {
            dfs(point + 1, cur + c, score + 1);
            dfs(point + 1, cur, score);
        } else if (c == ')') {
            dfs(point + 1, cur + c, score - 1);
            dfs(point + 1, cur, score);
        } else {
            dfs(point + 1, cur + c, score);
        }
    }

}
