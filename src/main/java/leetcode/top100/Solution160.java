package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution160.java, v 0.1 2022年07月28日 8:18 ziyou.cxf Exp $
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != headB) {
            headA = headA.next == null ? headB : headA.next;
            headB = headB.next == null ? headA : headB.next;
        }
        return headA;
    }
}
