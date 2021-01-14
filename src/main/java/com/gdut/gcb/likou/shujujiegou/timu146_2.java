package com.gdut.gcb.likou.shujujiegou;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 *
 * 实现 LRUCache 类：
 *
 *     LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 *     int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *     void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/1/10 17:21
 * @Version 1.0
 **/

/**
 * 这个跟timu146的区别就是timu146_2的双向链表的节点Node没有存val的值，https://labuladong.gitee.io/algo/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/LRU%E7%AE%97%E6%B3%95.html
 * 这个文章里说Node要存key和val，所以在这里进行了验证，确实是不能去掉的
 */
public class timu146_2 {
    public static void main(String[] args) {
        LRUCache2 lruCache = new LRUCache2(10);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        int i = lruCache.get(2);
        System.out.println(i);
    }
}

class LRUCache2 {
    // key -> Node(key, val)
    private HashMap<Integer, Node2> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList2 cache;
    // 最大容量
    private int cap;

    public LRUCache2(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList2();
    }

    public int get(int key) {
        // 将该数据提升为最近使用的
        Node2 x = map.get(key);
        // 先从链表中删除这个节点
        cache.remove(x);
        // 重新插到队尾
        cache.addLast(x);
        return x.val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            // 删除旧的数据
            Node2 x = map.get(key);
            // 从链表中删除
            cache.remove(x);
            // 从 map 中删除

            // 新插入的数据为最近使用的数据
            Node2 x1 = new Node2(key );
            // 链表尾部就是最近使用的元素
            cache.addLast(x);
            // 别忘了在 map 中添加 key 的映射
            map.put(key, x1);
            return;
        }

        if (cap == cache.size()) {
            // 删除最久未使用的元素

            // 链表头部的第一个元素就是最久未使用的
            Node2 deletedNode = cache.removeFirst();
            // 同时别忘了从 map 中删除它的 key
            int deletedKey = deletedNode.key;
            map.remove(deletedKey);
        }

        // 添加为最近使用的元素
        Node2 x = new Node2(key);
        // 链表尾部就是最近使用的元素
        cache.addLast(x);
        // 别忘了在 map 中添加 key 的映射
        map.put(key, x);
    }
    


}

class DoubleList2 {
    // 头尾虚节点
    private Node2 head, tail;
    // 链表元素数
    private int size;

    public DoubleList2() {
        // 初始化双向链表的数据
        head = new Node2(0);
        tail = new Node2(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表尾部添加节点 x，时间 O(1)
    public void addLast(Node2 x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node2 x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public Node2 removeFirst() {
        if (head.next == tail)
            return null;
        Node2 first = head.next;
        remove(first);
        return first;
    }

    // 返回链表长度，时间 O(1)
    public int size() { return size; }

}

class Node2 {
    public int key, val;
    public Node2 next, prev;
    public Node2(int k) {
        this.key = k;
    }
}
