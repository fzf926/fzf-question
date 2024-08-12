package com.example.sync;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String[] a1 = a.split(" ");
            int[] array = Arrays.stream(a1).mapToInt(Integer::valueOf).toArray();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < array[1]; i++) {
                String c = in.nextLine();
                String[] c1 = c.split(" ");
                int[] temp = Arrays.stream(c1).mapToInt(Integer::valueOf).toArray();
                List<Integer> relateList = map.get(temp[0]);
                if (relateList == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(temp[1]);
                    map.put(temp[0], list);
                } else {
                    relateList.add(temp[1]);
                }
            }
            int[][] opt = new int[array[2]][3];
            for (int i = 0; i < array[2]; i++) {
                String c = in.nextLine();
                String[] c1 = c.split(" ");
                int[] temp = Arrays.stream(c1).mapToInt(Integer::valueOf).toArray();
                for (int j = 0; j < 3; j++) {
                    opt[i][j] = temp[j];
                }
            }
            for (int i = 0; i < opt.length; i++) {
                List<Integer> one = map.get(opt[i][1]);
                List<Integer> two = map.get(opt[i][2]);
                if (opt[i][0] == 1) {
                    if (one != null) {
                        one.remove((Integer) opt[i][2]);
                    }
                    if (two != null) {
                        one.remove((Integer) opt[i][1]);
                    }
                    continue;
                }
                boolean result = false;
                if (one != null) {
                    for (Integer integer : one) {
                        List<Integer> integers = map.get(integer);
                        if (integers == null || integers.isEmpty()) {
                            continue;
                        }
                        if (integers.contains(opt[i][2])) {
                            result = true;
                        }
                    }
                }
                if (two != null && result == false) {
                    for (Integer integer : two) {
                        List<Integer> integers = map.get(integer);
                        if (integers == null || integers.isEmpty()) {
                            continue;
                        }
                        if (integers.contains(opt[i][1])) {
                            result = true;
                        }
                    }
                }
                System.out.println(result == true ? "Yes" : "No");
            }
        }
    }
}

