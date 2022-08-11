package com.example.test;

import java.util.*;

/**
 * @Author: fengluo
 * @Date: 2022/8/6 10:48
 */
public class Test {

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            heap.offer(random.nextInt());
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
        int[] temp = new int[]{0, 1};
        List<int[]> ints = Arrays.asList(temp);

    }
}
