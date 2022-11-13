package leetcode.top100;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author ziyou.cxf
 * @version : Solution105.java, v 0.1 2022年07月08日 16:30 ziyou.cxf Exp $
 */
public class Solution105 {

    public static void main(String[] args) {
        Solution105 solution105 = new Solution105();
        TreeNode treeNode = solution105.buildTree(new int[]{1,2}, new int[]{2,1});
        System.out.println("hello world");
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> data = Maps.newHashMap();
        for (int i = 0; i < preorder.length; i++) {
            data.put(inorder[i], i);
        }
       return deepBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, data);
    }

    private TreeNode deepBuildTree(int[] preorder, int preleft, int preright, int[] inorder, int inleft, int inright, Map<Integer, Integer> data) {
        if (preleft > preright) {
            return null;
        }

        int rootPoint = data.get(preorder[preleft]);
        int leftSize = rootPoint - inleft;

        TreeNode treeNode = new TreeNode(preorder[preleft]);
        treeNode.left = deepBuildTree(preorder, preleft + 1, preleft + leftSize, inorder, 0, rootPoint, data);
        treeNode.right = deepBuildTree(preorder, preleft  + leftSize +1, preright, inorder, rootPoint + 1, inright, data);

        return treeNode;
    }
}
