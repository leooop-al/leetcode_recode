package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution19.java, v 0.1 2022年04月04日 18:24 ziyou.cxf Exp $
 */
public class Solution19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode root = new ListNode(0, head);
        int length = getLength(head);

        ListNode cur = root;
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return root.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
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
