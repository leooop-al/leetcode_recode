package leetcode.top100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ziyou.cxf
 * @version : Solution94.java, v 0.1 2022年04月08日 17:33 ziyou.cxf Exp $
 */
public class Solution94 {

    public static void main(String[] args) {
        Solution94 solution94 = new Solution94();

        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);

        a.right = a1;
        a1.left = a2;

        System.out.println(solution94.inorderTraversal(a));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> target = new ArrayList<>();
        inorderTraversal(target, root);
        return target;
    }

    private void inorderTraversal(List<Integer> target, TreeNode cur) {
        if (cur == null) {
            return;
        }
        inorderTraversal(target, cur.left);
        target.add(cur.val);
        inorderTraversal(target, cur.right);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> target = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            target.add(pop.val);
            if (null != pop.right) {
                stack.push(pop.right);
            }
        }
        return target;
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
