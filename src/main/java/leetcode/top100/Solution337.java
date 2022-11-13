package leetcode.top100;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author ziyou.cxf
 * @version : Solution337.java, v 0.1 2022年08月14日 9:55 ziyou.cxf Exp $
 * @desc : 打家劫舍
 */
public class Solution337 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        Solution337 solution337 = new Solution337();
        System.out.println(solution337.rob(root));
    }

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memo = Maps.newHashMap();
        return dfs(root, memo);
    }

    private int dfs(TreeNode cur, Map<TreeNode, Integer> memo ) {
        if (null == cur) {
            return 0;
        }
        if (memo.containsKey(cur)) {
            return memo.get(cur);
        }
        int money = cur.val;
        if (cur.left != null) {
            money += dfs(cur.left.left, memo) + dfs(cur.left.right, memo);
        }
        if (cur.right != null) {
            money += dfs(cur.right.left, memo) + dfs(cur.right.right, memo);
        }
        int result = Math.max(dfs(cur.left, memo) + dfs(cur.right, memo), money);
        memo.put(cur, result);
        return result;
    }
}
