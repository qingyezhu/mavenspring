package com.wangzhu.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wang.zhu on 2021-03-28 22:23.
 **/
public class LRUCacheGenerics<K, V> {

    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + (next == null ? null : next.value) +
                    ", prev=" + (prev == null ? null : prev.value) +
                    '}';
        }
    }

    private static final int MAX_SIZE = 1 << 30;

    private final int capacity;
    private int size;
    private final Map<K, Node<K, V>> map;

    private Node<K, V> head;
    private Node<K, V> tail;

    public LRUCacheGenerics(final int initialCapacity) {
        if (initialCapacity < 0 || initialCapacity > MAX_SIZE) {
            //太大了
            throw new IllegalArgumentException("无效参数");
        }
        this.capacity = initialCapacity;

        //map后续不需要扩容
        final int mapInitialCapacity = (int) ((float) initialCapacity / 0.75F + 1.0F);
        this.map = new HashMap<>(mapInitialCapacity);
    }

    public V put(final K key, final V value) {
        V oldValue = null;
        Node<K, V> node = map.get(key);
        if (node != null) {
            oldValue = node.value;
            removeNode(node);
            //更新
            node.value = value;
        } else {
            if (size == capacity) {
                final Node<K, V> tail = this.tail;
                //删除元素
                map.remove(tail.key);
                //减少个数
                size--;
                removeNode(tail);
            }
            node = new Node<>(key, value);
            map.put(key, node);
            //更新个数
            size++;
        }
        addHead(node);
        return oldValue;
    }

    private void addHead(final Node<K, V> node) {
        if (this.head == null) {
            this.tail = node;
        } else {
            final Node head = this.head;
            node.next = head;
            head.prev = node;
        }
        this.head = node;
    }

    private void removeNode(final Node<K, V> node) {
        final Node<K, V> prev = node.prev;
        final Node<K, V> next = node.next;
        if (prev == null && next == null) {
            //只有一个元素
            this.head = this.tail = null;
        } else if (prev == null) {
            //第一个元素
            this.head = next;
            next.prev = null;
        } else if (next == null) {
            //最后一个元素
            this.tail = prev;
            prev.next = null;
        } else {
            //中间元素
            prev.next = next;
            next.prev = prev;
        }
        node.next = null;
        node.prev = null;
    }

    public V get(K key) {
        final Node<K, V> node = this.map.get(key);
        if (node == null) {
            return null;
        }
        final V oldValue = node.value;
        removeNode(node);
        addHead(node);
        return oldValue;
    }

    public void print() {
        Node<K, V> node = this.head;
        while (node != null) {
            System.out.print("(" + node.key + "," + node.value + ")" + "->");
            node = node.next;
        }
        System.out.println();
        for (final Map.Entry<K, Node<K, V>> entry : this.map.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue() + "-->");
        }
        System.out.println("-------");
    }

    public static void main(String[] args) {
        final LRUCacheGenerics<Integer, Integer> lruCacheGenerics = new LRUCacheGenerics<>(2);
        lruCacheGenerics.put(2, 1);
        lruCacheGenerics.put(2, 2);
        lruCacheGenerics.print();
        System.out.println(lruCacheGenerics.get(2));
        lruCacheGenerics.print();
        lruCacheGenerics.put(1, 1);
        lruCacheGenerics.print();
        lruCacheGenerics.put(4, 1);
        lruCacheGenerics.print();
        System.out.println(lruCacheGenerics.get(2));
        lruCacheGenerics.print();
    }

}
