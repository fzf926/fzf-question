package com.example.sync;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int length = in.nextInt();
            int count = in.nextInt();
            int[] value = new int[length];
            for (int i = 0; i < length; i++) {
                value[i] = in.nextInt();
            }
            int[][] ques = new int[count][2];
            for (int i = 0; i < count; i++) {
                ques[i][0] = in.nextInt();
                ques[i][1] = in.nextInt();
            }
            int zero = 0;
            int sumTemp = 0;
            for (int i = 0; i < value.length; i++) {
                if (value[i] == 0) {
                    zero++;
                    continue;
                }
                sumTemp+=value[i];
            }
            for (int i = 0; i < ques.length; i++) {
                int max;
                int min;
                if (ques[i][0] > ques[i][1]) {
                    max = ques[i][0];
                    min = ques[i][1];
                } else {
                    min = ques[i][0];
                    max = ques[i][1];
                }
                System.out.println((sumTemp + min * zero) + " " + (sumTemp + max * zero));
            }

        }
    }
}

