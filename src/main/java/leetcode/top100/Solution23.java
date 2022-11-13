package leetcode.top100;

import jdk.nashorn.internal.ir.CallNode;
import jdk.nashorn.internal.ir.WhileNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ziyou.cxf
 * @version : Solution23.java, v 0.1 2022年04月05日 16:47 ziyou.cxf Exp $
 */
public class Solution23 {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] listNodes, int lo, int hi) {
        if (lo == hi) {
            return listNodes[lo];
        }
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        return mergeTwoListNode(merge(listNodes, lo, mid), merge(listNodes, mid + 1, hi));
    }

    private ListNode mergeTwoListNode(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        }

        if (n2 == null) {
            return n1;
        }

        ListNode root = new ListNode(0);
        ListNode cur = root;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                cur.next = n1;
                n1 = n1.next;
                cur = cur.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
                cur = cur.next;
            }
        }

        if (n1 != null) {
            cur.next = n1;
        } else {
            cur.next = n2;
        }

        return root.next;
    }

    public class ListNode {
        int val;
        Solution23.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, Solution23.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
