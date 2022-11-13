package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution206.java, v 0.1 2022年07月29日 8:29 ziyou.cxf Exp $
 * @desc : 92 反转链表2
 */
public class Solution206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution206 solution206 = new Solution206();
        ListNode listNode = solution206.reverseBetween(head, 3, 4);
        System.out.println("test");
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode xx = head;

        ListNode prev = null;
        ListNode after = null;
        int count = 1;
        while (null != xx) {
            if (count == left - 1) {
                prev =xx;
            }
            if (count == right + 1) {
                after =xx;
            }
            xx = xx.next;
            count++;
        }

        ListNode root = head;
        ListNode tt = dfs(head, 1, left, right);

        if (null != prev) {
            prev.next = tt;
        }
        if (null != after) {
            ListNode tx  = tt;
            while (tx.next != null) {
                tx = tx.next;
            }
            tx.next = after;
        }
        return null == prev ? tt : head;
    }

    private static ListNode dfs(ListNode cur, int count, int left , int right) {
        if (cur == null || cur.next == null || count >= right ) {
            return cur;
        }
        ListNode newHead = dfs(cur.next, count+1, left, right);
        if (count < left) {
            return newHead;
        }
        cur.next.next = cur;
        cur.next = null;
        return newHead;
    }
}
