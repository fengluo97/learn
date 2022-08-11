import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fengluo
 * @Date: 2022/8/8 14:58
 */
@Slf4j(topic = "c.Test25")
public class Test25 {

    static final Object lock = new Object();
    static boolean t2runned = false;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                while (!t2runned) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
                lock.notifyAll();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock) {
                log.debug("2");
                t2runned = true;
                lock.notifyAll();
            }
        }, "t2").start();
    }

}
