package leetcode.top101;

import leetcode.top100.Solution;

/**
 * @author ziyou.cxf
 * @version : Solution2.java, v 0.1 2022年08月27日 18:36 ziyou.cxf Exp $
 */
public class Solution2 {

    public static void main(String[] args) {
        ListNode root1 = new ListNode(2);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(9);

        ListNode root2 = new ListNode(5);
        root2.next = new ListNode(6);
        root2.next.next = new ListNode(4);
        root2.next.next.next = new ListNode(9);

        Solution2 solution2 = new Solution2();
        ListNode listNode = solution2.addTwoNumbers(root1, root2);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int p = 0;

        ListNode ans = new ListNode(-1);
        ListNode cur = ans;
        while (l1 != null || l2 != null) {
            int sum = (null != l1 ? l1.val : 0) + (null!= l2 ? l2.val : 0) + p;
            p = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }

        if (p != 0) {
            cur.next = new ListNode(p);
        }
        return ans.next;
    }
}
