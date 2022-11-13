package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution148.java, v 0.1 2022年07月24日 17:30 ziyou.cxf Exp $
 */
public class Solution148 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode listNode = new Solution148().sortList(head);
        System.out.println(listNode);
    }

    public ListNode sortList(ListNode head) {
        ListNode a = head;
        while (a.next != null) {
            ListNode b = a.next;
            if (a.val > b.val) {
                a.next = b.next;
                if (b.val <= head.val) {
                    b.next = head;
                    head = b;
                } else {
                    ListNode c = head;
                    ListNode d = head;
                    while (b.val > c.val) {
                        d = c;
                        c = c.next;
                    }
                    d.next = b;
                    b.next = c;
                }
            } else {
                a = a.next;
            }
        }
        return head;
    }
}
