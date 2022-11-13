package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution141.java, v 0.1 2022年07月20日 21:30 ziyou.cxf Exp $
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode a = head;
        ListNode b = head.next;

        while (null != a && null != b) {
            if (a == b) {
                return true;
            }
            a = a.next;
            b = b.next;
            if (null != b) {
                b = b.next;
            }
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
