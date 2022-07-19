package thread.create;

/**
 * @Author: fengluo
 * @Date: 2022/7/17 18:28
 */
public class RannableDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread2());
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程：" + i);
        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("分：" + i);
        }
    }
}
