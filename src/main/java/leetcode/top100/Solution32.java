package leetcode.top100;

import java.util.Stack;

/**
 * @author ziyou.cxf
 * @version : Solution32.java, v 0.1 2022年04月10日 15:59 ziyou.cxf Exp $
 */
public class Solution32 {

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        if (null == s || s.length() <= 1) {
            return 0;
        }

        int maxLength = 0;
        Stack<Integer> stacks = new Stack<>();
        stacks.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stacks.push(i);
            } else {
                stacks.pop();
                if (stacks.isEmpty()) {
                    stacks.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stacks.peek());
                }
            }
        }
        return maxLength;
    }
}