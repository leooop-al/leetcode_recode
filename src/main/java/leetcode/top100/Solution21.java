package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution21.java, v 0.1 2022年04月05日 16:06 ziyou.cxf Exp $
 */
public class Solution21 {

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode(0);

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode cur = root;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = null != list1 ? list1 : list2;
        return root.next;
    }

    public class ListNode {
        int val;
        Solution21.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, Solution21.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
