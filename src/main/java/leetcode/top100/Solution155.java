package leetcode.top100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ziyou.cxf
 * @version : Solution155.java, v 0.1 2022年07月26日 8:35 ziyou.cxf Exp $
 */
public class Solution155 {

   private Deque<Integer> queue = new LinkedList<>();

    private Deque<Integer> minQ = new LinkedList<>();

    public Solution155() {
        queue = new LinkedList<>();
        minQ = new LinkedList<>();
        minQ.push(Integer.MAX_VALUE);
    }


    public void push(int val) {
        queue.push(val);
        minQ.push(Math.min(minQ.peek(), val));
    }

    public void pop() {
        queue.pop();
        minQ.pop();
    }

    public int top() {
        return queue.peek();
    }

    public int getMin() {
        return minQ.peek();
    }

}
