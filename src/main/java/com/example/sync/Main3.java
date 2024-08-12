package com.example.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 注意类名必须为 Main3, 不要有任何 package xxx 信息
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                int c = in.nextInt();
                list.add(c);
            }
            int fast = Integer.MAX_VALUE;
            double maxTime = 0;
            int s = 0;
            int[] record = new int[a];
            int count = 0;
            while (s < b) {
                for (int i = 0; i < a; i++) {
                    record[i] = list.get(i) + record[i];
                }
                int max = Integer.MAX_VALUE;
                for (int i = 0; i < record.length; i++) {
                    if (record[i] < max) {
                        max = record[i];
                    } else {
                        record[i] = max;
                    }
                    if (i == a - 1) {
                        count++;
                        s = record[i];
                    }
                }
            }
            double result = (s - b) / (double)list.get(a - 1);
            System.out.println(result);
        }
    }
}