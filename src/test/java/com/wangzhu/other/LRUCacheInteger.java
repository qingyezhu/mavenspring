package com.wangzhu.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wang.zhu on 2021-03-28 23:59.
 **/
public class LRUCacheInteger {


    static class Node {
        final int key;
        int value;
        Node next;
        Node prev;

        Node(final int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    final int capacity;
    final Map<Integer, Node> map;
    int size;
    Node head, tail;

    public LRUCacheInteger(int capacity) {
        this.capacity = capacity;
        final int initialCapacity = (int) ((float) capacity / 0.75F + 1.0F);
        this.map = new HashMap<>(initialCapacity);
    }

    public int get(int key) {
        final Node node = this.map.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addHeadNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = this.map.get(key);
        if (node != null) {
            //存在更新
            removeNode(node);
            node.value = value;
        } else {
            if (this.size == this.capacity) {
                Node tail = this.tail;
                this.map.remove(tail.key);
                size--;
                removeNode(tail);
            }
            node = new Node(key, value);
            this.map.put(key, node);
            this.size++;
        }
        addHeadNode(node);
    }

    private void removeNode(final Node node) {
        final Node prev = node.prev, next = node.next;
        if (prev == null && next == null) {
            this.head = this.tail = null;
        } else if (prev == null) {
            //头节点
            this.head = next;
            next.prev = null;
        } else if (next == null) {
            //尾节点
            this.tail = prev;
            prev.next = null;
        } else {
            //中间节点
            prev.next = next;
            next.prev = prev;
        }
        node.prev = null;
        node.next = null;
    }

    private void addHeadNode(final Node node) {
        if (this.tail == null) {
            this.tail = node;
        } else {
            Node head = this.head;
            node.next = head;
            head.prev = node;
        }
        this.head = node;
    }
}
