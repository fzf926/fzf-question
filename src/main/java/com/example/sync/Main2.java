package com.example.sync;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 注意类名必须为 Main2, 不要有任何 package xxx 信息
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            String c = in.nextLine();
            String d = in.nextLine();
            int[] first = Arrays.stream(a.split(" ")).mapToInt(Integer::valueOf).toArray();
            int[] second = Arrays.stream(b.split(" ")).mapToInt(Integer::valueOf).toArray();
            int[] third = Arrays.stream(c.split(" ")).mapToInt(Integer::valueOf).toArray();
            int[] fourth = Arrays.stream(d.split(" ")).mapToInt(Integer::valueOf).toArray();
            int total = first[0];
            int money = first[1];
            int max = first[2];
            int result = handle(total, money, max, second, third, fourth, 0, 0, "", 0);
            List<String> stringList = map.get(result);
            StringBuffer q = new StringBuffer();
            for (int i = 0; i < stringList.size(); i++) {
                if (i == stringList.size() - 1) {
                    q.append(stringList.get(i));
                    continue;
                }
                q.append(stringList.get(i)).append(" ");

            }
            System.out.println(q);
        }
    }

    public static Map<Integer, List<String>> map = new HashMap<>();

    public static int handle(int total, int money, int max, int[] second, int[] third, int[] fourth, int index, int result, String value, int count) {
        if (money < 0 || max < 0 || index >= total || count >= 2) {
            String[] split = value.split(" ");
            split[split.length - 1] = "0";
            map.put(result, Arrays.asList(split));
            return result;
        }
        if (max == 0 && money > 0) {
            String[] split = value.split(" ");
            map.put(result, Arrays.asList(split));
            return result;
        }
        if (money == 0 && max > 0) {
            String[] split = value.split(" ");
            map.put(result, Arrays.asList(split));
            return result;
        }
        if (index >= total) {
            String[] split = value.split(" ");
            map.put(result, Arrays.asList(split));
            return result;
        }
        int current = fourth[index] * second[index];
        int result1 = handle(total,
            money - fourth[index], max - third[index], second, third, fourth, index + 1, result + current, value + fourth[index] + " ", count + 1);
        int result2 = handle(total, money, max, second, third, fourth, index + 1, result, value + 0 + " ", count);
        return Math.max(result1, result2);
    }
}