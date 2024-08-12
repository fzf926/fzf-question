package com.example.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaofang.fan@hand-china.com 2024/5/21 15:48
 */
public class gcTest {


    public static void main(String[] args) {
//        WeakReference<Object> object = new WeakReference<>(new Object());
        extracted();

//
    }
//
    private static void extracted() {
        {
            byte[] byte1 = new byte[10 * 1024 * 1024];


        }
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        System.gc();
    }
}
