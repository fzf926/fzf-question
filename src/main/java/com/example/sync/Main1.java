package com.example.sync;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

// 注意类名必须为 Main1, 不要有任何 package xxx 信息
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String origin =
            "The furthest distance in the world, Is not between life and death, But when I stand in front of you, Yet you don't know that I love you";
        String userInput = "f";
        String[] split = origin.split(" ");
        List<String> collected = Arrays.stream(split).sorted().collect(Collectors.toList());
        byte[] bytes = userInput.getBytes();
        Set<String> resultList = new LinkedHashSet<>();
        for (int i = 1; i <= bytes.length; i++) {
            String substring = userInput.substring(0, i);
            Set<String> matchList =
                collected.stream().filter(v -> v.startsWith(substring)).collect(Collectors.toSet());
            if (!matchList.isEmpty()) {
                resultList = matchList;

                resultList = matchList;
                resultList = matchList;
                resultList = matchList;
            }
        }
        StringBuffer result = new StringBuffer();
        List<String> collected1 =
            resultList.stream().collect(Collectors.toList()).stream().sorted().collect(Collectors.toList());
        collected1.forEach(v -> result.append(v + " "));
        if (result.length() == 0) {
            System.out.println(userInput);
        } else {
            System.out.println(result.substring(0, result.length() - 1));
        }
    }
}