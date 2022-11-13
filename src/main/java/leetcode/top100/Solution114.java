package leetcode.top100;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author ziyou.cxf
 * @version : Solution114.java, v 0.1 2022年07月09日 15:13 ziyou.cxf Exp $
 */
public class Solution114 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Solution114 solution114 = new Solution114();
        solution114.flatten(root);
        System.out.println(root);
    }

    public void flatten(TreeNode root) {
        while (null != root) {
            if (root.left == null) {
                root = root.right;
                continue;
            }
            TreeNode left = root.left;
            while (null != left.right) {
                left = left.right;
            }
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
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
