package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : TreeNode.java, v 0.1 2022年08月14日 9:55 ziyou.cxf Exp $
 */

public class TreeNode {
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