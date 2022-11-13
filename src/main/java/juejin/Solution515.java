package juejin;

import leetcode.top100.Solution21;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziyou.cxf
 * @version : Solution515.java, v 0.1 2022年06月27日 9:32 ziyou.cxf Exp $
 */
public class Solution515 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode33 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode.left = treeNode3;
        treeNode.right = treeNode2;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode33;

        treeNode2.right = treeNode9;

        Solution515 solution515 = new Solution515();
        solution515.largestValues(treeNode);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        deepSearch(root, 0, ans);
        return ans;
    }

    private void deepSearch(TreeNode node, int level,List<Integer> ans) {
        if (null == node) {
            return;
        }
        if (ans.size() <= level) {
            ans.add(level, node.val);
        } else {
            Integer a = ans.get(level);
            ans.set(level, Math.max(a, node.val));
        }
        deepSearch(node.left, level + 1, ans);
        deepSearch(node.right, level + 1, ans);
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
