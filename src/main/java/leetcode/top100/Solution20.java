package leetcode.top100;

import java.util.Stack;

/**
 * @author ziyou.cxf
 * @version : Solution20.java, v 0.1 2022年04月05日 15:55 ziyou.cxf Exp $
 */
public class Solution20 {

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stacks = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stacks.isEmpty()) {
                stacks.push(s.charAt(i));
            } else {
                Character a = stacks.peek();
                Character b = s.charAt(i);
                if (a.equals('(') && b.equals(')')) {
                    stacks.pop();
                } else if (a.equals('{') && b.equals('}')) {
                    stacks.pop();
                } else if (a.equals('[') && b.equals(']')) {
                    stacks.pop();
                } else {
                    stacks.push(s.charAt(i));
                }
            }
        }
        return stacks.isEmpty();
    }
}
