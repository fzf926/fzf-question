package com.example.sync;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int count = in.nextInt();
            in.nextLine();
            String[] a = new String[count];
            for (int i = 0; i < count; i++) {
                a[i] = in.nextLine();
            }
            for (String s : a) {
                System.out.println(handle(s));
            }


        }
    }

    public static String handle(String value) {
        int match1 = 0;
        int match2 = 0;
        char[] bytes = value.toCharArray();
        int i = 1;
        char[] result = new char[bytes.length];
        char temp = bytes[0];
        boolean flag = false;
        int index = 0;
        while (i < bytes.length) {
            result[index] = temp;
            index++;
            if (temp == bytes[i]) {
                if (match1 == 1 && i >= 2 && temp != bytes[i - 2]) {
                    match2++;
                } else {
                    match1++;
                }
            } else {
                if (match1 == 1) {
                    flag = !flag;
                }
            }
            if (match1 == 2) {
                match1--;
                index--;
            }
            if (match2 == 1) {
                index--;
                match2--;
            }
            if (match1 == 1 && match2 == 1) {

            }
            temp = bytes[i];
            i++;
        }
        Thread thread = new Thread(() -> {
            System.out.println(1);
        });
        thread.start();
        result[index] = temp;
        StringBuffer buffer = new StringBuffer();
        for (int i1 = 0; i1 < index; i1++) {
            buffer.append(result[i1]);
        }

        return buffer.toString();
    }
}

