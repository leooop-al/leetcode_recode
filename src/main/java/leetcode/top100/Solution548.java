package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution548.java, v 0.1 2022年08月21日 8:57 ziyou.cxf Exp $
 */
public class Solution548 {


    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int result = (dsf(root.left) + dsf(root.right));
        int childResult = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(result, childResult);
    }

    private int dsf(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (null == root.left && null == root.right) {
            return 1;
        }

        return 1 + Math.max(dsf(root.left), dsf(root.right));
    }


    private int ans = 1;
    private int dsf2(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int L = dsf2(root.left);
        int R = dsf2(root.right);
        ans = Math.max(ans, L + R + 1);
        return 1 + Math.max(L, R);
    }
}
