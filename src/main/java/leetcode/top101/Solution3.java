package leetcode.top101;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ziyou.cxf
 * @version : Solution3.java, v 0.1 2022年08月28日 9:54 ziyou.cxf Exp $
 * @desc : 采用数组的方式
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> maps = new HashMap<>(16);

        int pre = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (maps.containsKey(c)) {
                pre = Math.max(pre, maps.get(c));
            }
            max = Math.max(i - pre, max);
            maps.put(c, i);
        }
        return max;
    }
}
