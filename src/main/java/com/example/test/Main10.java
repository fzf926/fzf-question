package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhaofang.fan@hand-china.com 2024/6/15 9:56
 */

//
public class Main10 {
    public static void main(String[] args) {
        String ip = "127.0.0.1"; // 2130706433
        String ip1 = "127.0.0.1."; // -1
        long i = convertToInt(ip1);
        System.out.println("result: " + i);
    }

    public static long convertToInt(String ip) {
        char[] chars = ip.toCharArray();
        int maxInt = 255;
        StringBuffer buffer = new StringBuffer();
        List<Long> resultList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '.') {
                buffer.append(chars[i]);
                continue;
            }
            String value = buffer.toString();
            long res = Long.valueOf(value);
            if (res > maxInt) {
                return -1L;
            }
            resultList.add(res);
            buffer = new StringBuffer();
        }
        String last = buffer.toString();
        resultList.add(Long.valueOf(last));
        long result = 0;
        int offset = 3;
        for (Long r : resultList) {
            result += r << (offset * 8);
            offset--;
        }
        return result;
    }
}
