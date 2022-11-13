package leetcode2;


/**
 * @author ziyou.cxf
 * @version : Leetcode2.java, v 0.1 2022年11月13日 21:04 ziyou.cxf Exp $
 * @desc: https://leetcode.cn/problems/add-two-numbers/submissions/
 * 一次通过，而且改良了当时的方案
 */
public class Leetcode2 {

    public static void main(String[] args) {
        Leetcode2 leetCode2 = new Leetcode2();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        leetCode2.addTwoNumbers(a, b);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode root = new ListNode(-1);
        ListNode cur = root;
        int left = 0;
        while (null != l1 || null != l2) {
            int v = (null != l1 ? l1.val : 0) + (null != l2 ? l2.val : 0) + left;
            int a = v % 10;
            int b = v / 10;

            cur.next = new ListNode(a);
            left = b;
            cur = cur.next;
            l1 = null != l1 ? l1.next : l1;
            l2 = null != l2 ? l2.next : l2;
        }
        if (left != 0) {
            cur.next = new ListNode(left);
        }

        return root.next;
    }
}
