package thread.concurrent;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: fengluo
 * @Date: 2022/7/17 20:11
 */
public class ConcurrentTest {

    // 1.古老的线程安全实现，性能差
    // 2.Collections.synchronizedXXX()包装类，性能差
    // 3.util.concurrent包下的并发集合类，性能较优
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Date, String> concurrentHashMap = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
        blockingQueue = new LinkedBlockingQueue<>(10);
        blockingQueue = new PriorityBlockingQueue<>(10); // 堆的线程安全版本
        ConcurrentSkipListMap<Integer, Integer> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
    }

}
