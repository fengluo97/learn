package thread.leetcode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: fengluo
 * @Date: 2022/7/17 20:54
 */
public class PrintProblem {

    private static int printNum = 10;
    private static int n = 2;
    private volatile static int cnt = 0;

    private static class Task implements Runnable {
        private final Lock lock = new ReentrantLock();
        @Override
        public void run() {
            while (printNum * n > cnt) {
                if (cnt % n == Integer.parseInt(Thread.currentThread().getName().substring(1)) - 1) {
                    lock.lock();
                    try {
                        cnt++;
                        System.out.print(Thread.currentThread().getName());
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        for (int i = 1; i <= n; i++) {
            new Thread(task, "T" + i).start();
        }
    }
}







