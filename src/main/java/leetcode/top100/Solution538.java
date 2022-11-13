package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution538.java, v 0.1 2022年08月20日 21:52 ziyou.cxf Exp $
 */
public class Solution538 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        convertBST(root);
    }

    public static TreeNode convertBST(TreeNode root) {
        TreeNode ans = root;
        dfs(root);
        return ans;
    }

    private static int sum = 0;

    private static void dfs(TreeNode root) {
        if (null == root) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
