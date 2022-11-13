package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution5.java, v 0.1 2022年07月23日 11:48 ziyou.cxf Exp $
 * @desc : 中心扩展法
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("a"));
    }

    public String longestPalindrome(String s) {
        int low = 0;
        int hi = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int max1 = expendMaxLength(s, i, i);
            int max2 = expendMaxLength(s, i, i + 1);
            if (maxLength > max1 && maxLength > max2) {
                continue;
            }
            maxLength = Math.max(max1, max2);
            low = i - maxLength / 2;
            if (max1 > max2) {
                hi = i + maxLength / 2;
            } else {
                hi = i + maxLength / 2 + 1;
            }
        }
       return s.substring(low, hi+1);
    }

    private int expendMaxLength(String s, int i, int j) {
        while (i >= 0 && j < s.length() && j >= i && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j-i-2;
    }
}
