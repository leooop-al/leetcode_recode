package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziyou.cxf
 * @version : Solution22.java, v 0.1 2022年04月05日 16:24 ziyou.cxf Exp $
 */
public class Solution22 {

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();

        List<String> strings = solution22.generateParenthesis(3);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, "", n, n);
        return result;
    }

    private void backTrack(List<String> result, String target, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(target.toString());
            return;
        }

        /**剪枝（如图，左括号可以使用的个数严格大于右括号使用的个数，才剪枝）*/
        if (left > right) {
            return;
        }

        if (left > 0) {
            backTrack(result, target + "(", left - 1, right);
        }

        if (right > 0) {
            backTrack(result, target + ")", left, right -1);
        }
    }
}
