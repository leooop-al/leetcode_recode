package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution142.java, v 0.1 2022年07月20日 21:56 ziyou.cxf Exp $
 * @desc : 环形链表 -> 获取第一个进入环的节点
 */
public class Solution142 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        Solution142 solution142 = new Solution142();
        solution142.detectCycle(head);
    }

    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (null != fast) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (null == slow) {
            return null;
        }

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}
