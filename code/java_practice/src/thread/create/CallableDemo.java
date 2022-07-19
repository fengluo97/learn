package thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: fengluo
 * @Date: 2022/7/17 18:41
 */
public class CallableDemo {

    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread3);
        Thread t = new Thread(futureTask, "分");
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程：" + i);
        }

        try {
            System.out.println(futureTask.get()); // futureTask，异步的计算任务，main线程等待分线程执行完毕后get获取返回值
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class MyThread3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for ( ; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ":  " + i);
        }
        return i;
    }
}
