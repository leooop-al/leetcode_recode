package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution124.java, v 0.1 2022年07月10日 9:47 ziyou.cxf Exp $
 */
public class Solution124 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int i = new Solution124().maxPathSum(root);
        System.out.println();
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
         maxDeepSearch(root);
         return maxSum;
    }

    private int maxDeepSearch(TreeNode root) {
        if (null == root) {
            return 0;
        }

        //
        int leftGain = Math.max(maxDeepSearch(root.left), 0);
        int rightGrain = Math.max(maxDeepSearch(root.right), 0);

        int price = root.val + leftGain + rightGrain;
        maxSum = Math.max(maxSum, price);


        return root.val + Math.max(leftGain, rightGrain);
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
