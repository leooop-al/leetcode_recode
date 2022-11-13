package leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ziyou.cxf
 * @version : LRUCache.java, v 0.1 2022年07月21日 22:45 ziyou.cxf Exp $
 */
public class LRUCache {

    private final int capacity;

    private final Map<Integer, Node> maps;

    private final Node head;

    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.maps = new HashMap<>(capacity);
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.before = head;
    }

    public int get(int key) {
        if (!maps.containsKey(key)) {
            // 未找到
            return -1;
        }
        Node a = maps.get(key);
        remove(a);

        Node b = head.next;
        head.next = a;
        a.before = head;
        a.next = b;
        b.before = a;

        return a.v;
    }

    public void put(int key, int value) {
        if (maps.containsKey(key)) {
            Node node = maps.get(key);
            node.v = value;
            get(key);
            return;
        }
        Node a = new Node(key, value);
        Node b = head.next;
        head.next = a;
        a.before = head;

        a.next = b;
        b.before = a;

        maps.put(key, a);
        if (maps.keySet().size() > capacity) {
            maps.remove(tail.before.k);
            remove(tail.before);
        }
    }

    private void remove(Node node) {
        Node beforeNode = node.before;
        Node nextNode = node.next;
        beforeNode.next = nextNode;
        nextNode.before = beforeNode;
    }

    private class Node {
        private int v;
        private int k;

        private Node before;
        private Node next;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 0);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
