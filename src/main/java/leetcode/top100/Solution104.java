package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution104.java, v 0.1 2022年07月08日 17:29 ziyou.cxf Exp $
 */
public class Solution104 {

    public static void main(String[] args) {
        Solution104 solution104 = new Solution104();
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);

        a.right = a1;
        a1.left = a2;

        solution104.flatten(a);
    }

    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode ans = new TreeNode(-1);
        deepFlatten(root, ans);
        root.right = ans.right.right;
        root.left = null;
    }

    private void deepFlatten(TreeNode root, TreeNode ans) {
        if (null == root) {
            return;
        }
        ans.right = new TreeNode(root.val);
        ans.left = null;
        deepFlatten(root.left, ans.right);
        deepFlatten(root.right, ans.right);
    }

    private static class TreeNode {
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
