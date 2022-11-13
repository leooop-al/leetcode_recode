package leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ziyou.cxf
 * @version : Leetcode3.java, v 0.1 2022年11月13日 21:20 ziyou.cxf Exp $
 */
public class Leetcode3 {

    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        int ans = leetcode3.lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<>(32);
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 保证取到的left一定是合理的
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
