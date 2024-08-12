package com.example.sync;

import java.util.ArrayList;
import java.util.List;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main7 {
    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        List<Integer> value = new ArrayList<>();
        boolean handle = handle(a, b, value);
        if (handle) {
            value.add(1);
        }
        value.forEach(System.out::println);
        value.forEach(System.out::println);
        value.forEach(System.out::println);
        value.forEach(System.out::println);

    }

    public static boolean handle(ListNode a, ListNode b, List<Integer> result) {
        if (a == null && b == null) {
            return false;
        }

        if (a == null) {
            // a 为null的情况下不会出现进位的情况
            handle(null, b.next, result);
            result.add(b.val);
            return false;
        }
        if (b == null) {
            // b 为null的情况下不会出现进位的情况
            handle(a.next, null, result);
            result.add(a.val);
            return false;
        }
        boolean handle = handle(a.next, b.next, result);
        int sum = a.val + b.val + (handle ? 1 : 0);
        if (sum >= 10) {
            result.add(sum - 10);
            return true;
        }
        result.add(sum);
        return false;
    }


}

