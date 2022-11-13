package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziyou.cxf
 * @version : Solution98.java, v 0.1 2022年07月04日 8:10 ziyou.cxf Exp $
 */
public class Solution98 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 5;
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        Solution98 solution98 = new Solution98();
        System.out.println(solution98.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        buildBSTList(root, ans);

        long min = Long.MIN_VALUE;
        for (Integer item : ans) {
            if (item < min) {
                return false;
            }
            min = item;
        }
        return true;
    }

    private void buildBSTList(TreeNode root, List<Integer> ans) {
        if (null == root) {
            return;
        }

        buildBSTList(root.left, ans);
        ans.add(root.val);
        buildBSTList(root.right, ans);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
