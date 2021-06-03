package com.wangzhu.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by wang.zhu on 2021-05-27 15:49.
 **/
public class Test {

    //单向链表
    //反转链表

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
//        ListNode listNode = create(nums);
//        print(listNode);
//        ListNode reverseListNode = reverse(listNode);
//        System.out.println("反转后---");
//        print(reverseListNode);
        String strA = "255.255.1.255";
        int ret = transferInt(strA);
        System.out.println("ret=" + ret);
        String strB = transferStr(ret);
        System.out.println("strA=" + strA);
        System.out.println("strB=" + strB);
    }

    static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println();
    }

    static ListNode create(int[] nums) {
        ListNode head = new ListNode();
        ListNode tail = head;
        for (int i = 0, len = nums.length; i < len; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
        return head.next;
    }

    static ListNode reverse(ListNode listNode) {
        ListNode head = null;
        while (listNode != null) {
            ListNode next = listNode.next;

            listNode.next = head;
            head = listNode;

            listNode = next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static int transferInt(String str){
        if(str == null || str.length() == 0){
            //
        }

        String[] arr = StringUtils.split(str, "\\.");
        if(arr.length != 4){
            //
        }
        int ret = 0;
        int i = 0;
        for(String item : arr){
            int num = Integer.parseInt(item);
            ret += num<<i;
            i+=8;
        }
        return ret;
    }

    static String transferStr(int num){
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        while(num != 0){
            if(flag){
                stringBuilder.append(".");
            }
            stringBuilder.append(num &(0xff));
            num >>>= 8;
            flag = true;
        }
        return stringBuilder.toString();
    }
}
