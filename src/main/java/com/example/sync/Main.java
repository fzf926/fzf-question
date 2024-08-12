package com.example.sync;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int a = Integer.parseInt(in.nextLine());
            int[][] matrix = new int[a][a];
            for (int i = 0; i < a; i++) {
                String string = in.nextLine();
                String[] split = string.split("");
                for (int j = 0; j < split.length; j++) {
                    matrix[i][j] = Integer.parseInt(split[j]);
                }
            }
            int[] result = new int[a];
            result[0] = 0;
            for (int i = 1; i < a; i++) {
                // 每一个阶次都单独计数
                int count = 0;
                // x 的遍历下标为[0, a - i - 1）
                for (int j = 0; j < a - i; j++) {
                    // y 的遍历下标为[0, a - i - 1）
                    for (int k = 0; k < a - i; k++) {
                        int total = (i + 1) * (i + 1);
                        int zero = 0;
                        int one = 0;
                        int x = j;
                        int y = k;
                        while (total > 0) {
                            if (matrix[x][y] == 0) {
                                zero++;
                            } else {
                                one++;
                            }
                            if (x == j + i) {
                                x = j;
                                y++;
                            } else {
                                x++;
                            }
                            total--;
                        }
                        if (zero == one) {
                            count++;
                        }
                    }
                }
                result[i] = count;
            }
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }
}