package thread.create;

import javafx.concurrent.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: fengluo
 * @Date: 2022/7/17 19:06
 */
public class ThreadPoolDemo {

    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() + 1;
    private static final int MAX_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        // 线程池使用 ThreadPoolExecutor 创建，而不是 Executors，因为Executors不够明确，并且其提供的线程池可能导致OOM
        // ThreadPoolExecutor 参数
        // corePoolSize 核心线程池，CPU密集型任务（N+1），IO密集型任务（2N）
        // maximumPoolSize 线程池的最大线程数
        // keepAliveTime 当线程数大于核心线程数时，多余线程的存活的最长时间
        // unit 时间单位
        // workQueue 任务队列
        // threadFactory 线程工厂，用来创建线程，一般默认即可
        // handler 拒绝策略，当提交的任务过多而不能及时处理时的拒绝策略
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        TestTask task = new TestTask();
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(task);
        }
    }

}

class TestTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":  " + i);
        }
    }
}
